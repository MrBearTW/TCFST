val flights = spark.read
              .option("header", "true")
              .option("inferSchema", "true")
              .csv("test-02/flights.csv")

flights.createOrReplaceTempView("flightsView")

val sqlDF = spark.sql("""
    SELECT Carrier, TailNum, DepDelayMins, ArrDelay, Dist 
      FROM flightsView 
     LIMIT 20
""").show()

// define UDF for spark sql
spark.udf.register("isDelayedUDF", (time: String) => if (time == "NA") 0 else if (time.toInt > 15) 1 else 0)

val jdbcDF = spark.sql("SELECT Carrier, SUM(isDelayedUDF(DepDelayMins)) AS NumDelays FROM flightsView GROUP BY Carrier ORDER BY Carrier")

jdbcDF.show()
