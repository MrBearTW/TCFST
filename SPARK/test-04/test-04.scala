import org.apache.spark.sql.SparkSession

val spark = SparkSession
  .builder()
  .appName("Spark SQL basic example")
  .getOrCreate()

val dataFile = "test-02/flights.csv"
val outPath = "test-04/output"

// Create a DataFrame from CSV file
val flights = spark.read
              .option("header", "true")
              .option("inferSchema", "true")
              .csv( dataFile )


val delayedArrDF = flights.filter($"dest" === "ANC" || $"origin" === "ANC").filter($"depdelaymins" > 40)

val resultDF = delayedArrDF.select("dOfM", "DepDelayMins")
       .groupBy("dOfM").agg( count($"DepDelayMins"), avg($"DepDelayMins").alias("AvgDelay")).orderBy("dOfM")

resultDF.show()
// resultDF.write.format("csv").save(outPath)
