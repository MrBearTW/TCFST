import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types._
import spark.implicits._

val dataFile = "test-02/flights.csv"
val outPath = "test-04/output"

val mySchema = 
  StructType(
    StructField("dOfM", IntegerType, true) ::
    StructField("dOfW", StringType, true) ::
    StructField("carrier", StringType, true) ::
    StructField("tailNum", StringType, true) ::
    StructField("flnum", StringType, true) ::
    StructField("org_id", StringType, true) ::
    StructField("origin", StringType, true) ::
    StructField("dest_id", StringType, true) ::
    StructField("dest", StringType, true) ::
    StructField("crsdeptime", DoubleType, true) ::
    StructField("deptime", DoubleType, true) ::
    StructField("depdelaymins", DoubleType, true) ::
    StructField("crsarrtime", DoubleType, true) ::
    StructField("arrtime", DoubleType, true) ::
    StructField("arrdelay", DoubleType, true) ::
    StructField("crselapsedtime", DoubleType, true) ::
    StructField("dist", IntegerType, true) :: Nil
  )


// Create a DataFrame from CSV file
val flights = spark.read
              .schema(mySchema)
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

