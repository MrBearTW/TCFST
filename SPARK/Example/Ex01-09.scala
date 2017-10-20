// parallelizing example
val input = sc.parallelize(Array(1,2,3,3,6))

// Action example
input.collect()

input.count()

input.foreach(x=> println(x))

input.first()

input.take(5)

// input.saveAsTextFile("output")