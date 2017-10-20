// parallelizing example
val input = sc.parallelize(Seq(("A",1),("B",1),("C",1),("C",1)))

// Transformation
val newRDD = input.mapValues(x => x + 1)

// output result
newRDD foreach println