// Create a UDF to determine delays
import org.apache.spark.sql.functions.udf

val isDelayedUDF = udf((time: String) => if (time == "NA") 0 else if (time.toInt > 15) 1 else 0)

// Create a new DataFrame with IsDelayed column
val flightsWithDelays = flights.select($"dOfM", $"Carrier", $"TailNum", $"DepDelayMins", isDelayedUDF($"DepDelayMins").alias("IsDelayed"))
flightsWithDelays.show(5)

// Calculate percentage
flightsWithDelays.agg((sum("IsDelayed") * 100 / count("DepDelayMins")).alias("Percentage of Delayed Flights")).show()
