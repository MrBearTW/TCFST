import org.apache.spark.sql.SparkSession

import spark.implicits._

val dataFile = "test-02/flights.csv"
val outPath = "test-04/output"

// Create a DataFrame from CSV file
val flights = spark.read
              .option("header", "true")
              .option("inferSchema", "true")
              .csv( dataFile )

flights.createOrReplaceTempView("flightsView")

val sqlDF = spark.sql("""
  SELECT dOfM, COUNT(DepDelayMins) as CNT, AVG(DepDelayMins) as AVG
    FROM flightsView
   WHERE ((dest="ANC") Or (origin="ANC"))
     AND DepDelayMins > 40
   GROUP BY dOfM
   ORDER BY dOfM
""").show()

