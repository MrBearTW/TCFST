val input = sc.parallelize(Array(1,2,3,3,6))
val newRDD = input.map(x=>x+1) 
newRDD foreach println