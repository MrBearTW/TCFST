// parallelizing example
val input = sc.parallelize(Seq(("A","a,b"),("B","b,c"),("C","f,e,g"),("C","a,b")))

// Transformation
val newRDD = input.flatMapValues(x => x.split(","))

// output result
newRDD foreach println