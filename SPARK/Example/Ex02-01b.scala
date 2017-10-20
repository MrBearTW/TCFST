case class Student(id: Int, name: String, score: Double)

def parseData(str: String): Student = {
    val line = str.split(",")
    Student(line(0).toInt, line(1), line(2).toDouble)
}

val input=sc.parallelize(Array("1,Andy,90","2,Mary,95","3,John,89"))

val scoreRDD = input.map(parseData)

val downRDD = scoreRDD.filter( student => student.score < 90)
