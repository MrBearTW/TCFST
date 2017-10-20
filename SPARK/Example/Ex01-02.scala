// parallelizing example
val input = sc.parallelize(Array("2#3","4#5","3#4"))

// external datasets example
val newRDD = input.flatMap(x=>x.split("#")) 

// output result
newRDD foreach println