package example

import org.apache.spark.sql.SparkSession

import org.apache.spark.sql.types._
import org.apache.spark.sql.types.{StructType,StructField,StringType}

import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.classification.DecisionTreeClassifier
import org.apache.spark.ml.classification.DecisionTreeClassificationModel
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.ml.feature.{IndexToString, StringIndexer, VectorIndexer, VectorAssembler}


object FlightDelaySQL2 {

  def main(args: Array[String]) {

    val spark = SparkSession
      .builder()
      .appName("SparkDFebay")
      .getOrCreate()

    import spark.implicits._

    val struct =
      StructType(
        StructField("dofM", IntegerType, true) ::
          StructField("dofW", IntegerType, true) ::
          StructField("carrier", StringType, true) ::
          StructField("tailnum", StringType, true) ::
          StructField("flnum", StringType, true) ::
          StructField("org_id", StringType, true) ::
          StructField("origin", StringType, true) ::
          StructField("dest_id", StringType, true) ::
          StructField("dest", StringType, true) ::
          StructField("crsdeptime", IntegerType, true) ::
          StructField("deptime", IntegerType, true) ::
          StructField("depdelaymins", IntegerType, true) ::
          StructField("crsarrtime", IntegerType, true) ::
          StructField("arrtime", IntegerType, true) ::
          StructField("arrdelay", IntegerType, true) ::
          StructField("crselapsedtime", IntegerType, true) ::
          StructField("dist", IntegerType, true) :: Nil
      )

    /* -------------------------------- DataFrame ------------------------------------------ */
    val flightsDF = spark.read
      .schema(struct)
      .option("header", "true")
      .option("inferSchema", "true")
      .csv(args(0))
    //.csv("/home/williamlee/tmp/spark/t6/r2.csv")

    //Register as table
    flightsDF.createOrReplaceTempView("flights")

    /*----------------------------ENTRY TO SPARKSQL--------------------------*/
    //creating DF
    spark.udf.register("isDelayedUDF", (time: Int) => if (time > 40) 1 else 0)

    val flightDF = spark.sql(
      """
        |WITH c_carrier AS (
        |  SELECT carrier, ROW_NUMBER() OVER(PARTITION BY 1 ORDER BY carrier ASC) as seq
        |    FROM (SELECT carrier FROM flights GROUP BY carrier)
        |), c_origin AS (
        |  SELECT origin, ROW_NUMBER() OVER(PARTITION BY 1 ORDER BY origin ASC) as seq
        |    FROM (SELECT origin FROM flights GROUP BY origin)
        |), c_dest AS (
        |  SELECT dest, ROW_NUMBER() OVER(PARTITION BY 1 ORDER BY dest ASC) as seq
        |    FROM (SELECT dest FROM flights GROUP BY dest)
        |)
        |SELECT isDelayedUDF(depdelaymins) as label,
        |       (dofM-1) as monthday,
        |       (dofW-1) as weekday,
        |       x1.seq as carrierCat,
        |       x.carrier,tailnum,flnum,
        |       org_id,x.origin,x2.seq as originCat,
        |       dest_id,x.dest,x3.seq as destCat,
        |       crsdeptime,deptime,depdelaymins,
        |       crsarrtime,arrtime,arrdelay,crselapsedtime,
        |       dist
        |  FROM flights x, c_carrier x1, c_origin x2, c_dest x3
        | WHERE x.carrier = x1.carrier
        |   AND x.origin = x2.origin
        |   AND x.dest = x3.dest
      """.stripMargin)

    // Split the data into training and test sets (30% held out for testing).
    val Array(trainingData, testData) = flightDF.randomSplit(Array(0.7, 0.3), seed = 11L)

    println(s"---------------------------------- Extract features ---------------------------------------------------------")

    // Automatically identify categorical features, and index them.
    val assembler = new VectorAssembler()
      .setInputCols(Array("monthday", "weekday", "crsdeptime", "crsarrtime", "carrierCat", "crselapsedtime", "originCat", "destCat"))
      .setOutputCol("features")

    val labelIndexer = new StringIndexer()
      .setInputCol("label")
      .setOutputCol("indexedLabel")
      .fit(flightDF)

    // Automatically identify categorical features, and index them.
    val featureIndexer = new VectorIndexer()
      .setInputCol("features")
      .setOutputCol("indexedFeatures")
      .setMaxCategories(4) // features with > 4 distinct values are treated as continuous.

    val dt = new DecisionTreeClassifier()
      .setLabelCol("indexedLabel")
      .setFeaturesCol("indexedFeatures")
      .setImpurity("gini")
      .setMaxBins(7000)
//      .setMaxDepth(6)

    // Convert indexed labels back to original labels.
    val labelConverter = new IndexToString()
      .setInputCol("prediction")
      .setOutputCol("predictedLabel")
      .setLabels(labelIndexer.labels)

    println(s"---------------------------------- pipeline ---------------------------------------------------------")

    // Chain indexers and tree in a Pipeline.
    val pipeline = new Pipeline()
      .setStages(Array(assembler, labelIndexer, featureIndexer, dt, labelConverter))

    println(s"---------------------------------- model ---------------------------------------------------------")

    // Train model. This also runs the indexers.
    val model = pipeline.fit(trainingData)

    println(s"---------------------------------- prediction ---------------------------------------------------------")

    // Make predictions.
    val predictions = model.transform(testData)

    // Select example rows to display.
    predictions.select("predictedLabel", "label", "features").show(5)

    println(s"---------------------------------- evaluator ---------------------------------------------------------")

    // Select (prediction, true label) and compute test error.
    val evaluator = new MulticlassClassificationEvaluator()
      .setLabelCol("indexedLabel")
      .setPredictionCol("prediction")
      .setMetricName("accuracy")
    val accuracy = evaluator.evaluate(predictions)
    println("Test Error = " + (1.0 - accuracy))

    println(s"---------------------------------- treeModel ---------------------------------------------------------")

    val treeModel = model.stages(3).asInstanceOf[DecisionTreeClassificationModel]
    // println("Learned classification tree model:\n" + treeModel.toDebugString)

    println(s"-------------------------------------------------------------------------------------------")

  }
}

