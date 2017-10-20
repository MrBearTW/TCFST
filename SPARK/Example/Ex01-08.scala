// parallelizing example
val input = sc.parallelize(Array(1,2,3,4))

// Action example
val newRDD = input.reduce( (x,y) => x+y ) 
