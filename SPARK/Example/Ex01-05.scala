// parallelizing example
val rdd1 = sc.parallelize(Array(1,2,3))
val rdd2 = sc.parallelize(Array(2,4))

// external datasets example
val newRDD = rdd1.union(rdd2) 


// output result
newRDD foreach println