def func1(i: Int): Int = i + 1
val input = sc.parallelize(Array(1,2,3,3,6))
val newRDD = input.map(func1) 
newRDD foreach println