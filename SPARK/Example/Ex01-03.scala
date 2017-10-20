// Load data file
val input = sc.textFile("/usr/local/spark-2.2.0-bin-hadoop2.7/README.md")

// external datasets example
val wordCounts = input.flatMap(line => line.split(" "))
           .map( x=>(x,1))
           .reduceByKey((a, b) => a + b)

// output result
wordCounts.collect()
