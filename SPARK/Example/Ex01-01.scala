// parallelizing example
val input = sc.parallelize(Array(1,2,3,3,6))

// external datasets example
val newRDD = input.map(x=>x+1) 

// output result
newRDD foreach println
