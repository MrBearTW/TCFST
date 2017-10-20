val rdd1 = sc.textFile("/usr/local/spark-2.2.0-bin-hadoop2.7/README.md")
val rdd2 = rdd1.repartition(20)
val rdd3 = rdd2.coalesce(10)
