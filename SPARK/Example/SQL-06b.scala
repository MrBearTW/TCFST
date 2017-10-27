import org.apache.spark.sql.Row
import org.apache.spark.sql.types._

val mySchema = 
  StructType(
    StructField("name", StringType, true) ::
    StructField("score", StringType, true) :: Nil
  )

val peopleRDD = spark.sparkContext.textFile("Example/people.txt")

// Convert records of the RDD (people) to Rows
val rowRDD = peopleRDD
  .map(_.split(","))
  .map(attributes => Row(attributes(0), attributes(1).trim))

// Apply the schema to the RDD
val peopleDF = spark.createDataFrame(rowRDD, mySchema)

peopleDF.createOrReplaceTempView("people")

val results = spark.sql("SELECT name, score FROM people")

results.show()
