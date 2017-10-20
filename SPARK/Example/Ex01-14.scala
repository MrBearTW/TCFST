// parallelizing example
val rdd1 = sc.parallelize(Seq(("A",1),("B",2),("C",3),("D",4)))
val rdd2 = sc.parallelize(Seq(("A",4),("D",3)))

// Transformation
val newRDD = rdd1.join(rdd2) 

// output result
newRDD foreach println
