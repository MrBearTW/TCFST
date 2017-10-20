val input=sc.parallelize(Array("1,Andy,90","2,Mary,95","3,John,89"))
val scoreRDD = input.map(line => line.split(","))
val downRDD = scoreRDD.filter( arr => arr(2).toDouble < 90)
downRDD.collect()