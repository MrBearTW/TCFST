// parallelizing example
val input = sc.parallelize(Seq(("A",1),("B",1),("C",11),("C",12)))

// Transformation
val newRDD = input.reduceByKey( (x,y) => x + y )

// output result
newRDD foreach println