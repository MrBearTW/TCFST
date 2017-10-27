// load the input data
//val inputFile = sc.textFile("hdfs://piodev1:9000/user/t1.log")
val inputFile = sc.textFile("test-01/t1.log")
val dateString_1 = "2017-04-07"
val dateString_2 = "2017-04-11"
val keyWord = "logA"

val day_1 = inputFile.filter(line => line.contains(dateString_1))
                     .filter(line => line.contains("ERROR"))
val day_2 = inputFile.filter(line => line.contains(dateString_2))
                     .filter(line => line.contains("ERROR"))

val allDaysWords = day_1.union(day_2)

val words = allDaysWords.flatMap(line => line.split(" "))

// Transform into pairs and count
val counts = words.filter(word => word.equals(keyWord))
                  .map(word => (word, 1))
                  .reduceByKey(_ + _)

// Save the word count output
counts.saveAsTextFile("test-01/wordcount")

