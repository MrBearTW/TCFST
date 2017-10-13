
val input = sc.parallelize(Seq(("A",1),("B",1),("C",1),("C",1)))
val newRDD = input.reduceByKey ((x,y)=>x+y)
newRDD foreach println