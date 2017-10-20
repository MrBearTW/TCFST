// parallelizing example
val input = sc.parallelize(Seq(("A",1),("B",1),("C",11),("C",12)))

// Action
val retValue = input.collectAsMap

// output result
retValue foreach println
