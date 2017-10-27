val logData = sc.textFile("/usr/local/spark-2.2.0-bin-hadoop2.7/README.md")

val counts = logData
    .flatMap(line => line.split(" "))
    .map(word => (word, 1))
    .reduceByKey(_ + _)

counts.saveAsTextFile("wordcount")

