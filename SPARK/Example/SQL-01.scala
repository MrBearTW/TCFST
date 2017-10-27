import org.apache.spark.sql.SparkSession

val spark = SparkSession
  .builder()
  .appName("Spark SQL basic example")
  .getOrCreate()

// Create a DataFrame from CSV file
val flights = spark.read
              .option("header", "true")
              .option("inferSchema", "true")
              .csv("test-02/flights.csv")
