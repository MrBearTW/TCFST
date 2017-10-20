// parallelizing example
val input = sc.parallelize(Seq(("A",1),("B",2),("C",3),("C",4)))

// Transformation
val newRDD = input.groupByKey()

// output result
newRDD foreach println