// Load data file
val input = sc.textFile("/usr/local/spark-2.2.0-bin-hadoop2.7/README.md")

// parallelizing example
val rdd1 = input.filter(line => line.contains("spark"))
val rdd2 = input.filter(line => line.contains("Python"))

// external datasets example
val newRDD = rdd1.union(rdd2) 
