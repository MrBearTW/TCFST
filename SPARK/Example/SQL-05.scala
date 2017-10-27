// Create two records data of dataframe
import spark.implicits._

case class Person(name: String, score: Long)

val myDS1 = Seq(
        ("user4",400),
        ("user5",500)
        ).toDF("name", "score")

val myDS2 = Seq(
        Person("user4",400),
        Person("user5",500)
        ).toDF()

val peopleDS = spark.read.json("Example/people.json").as[Person]

myDS1.show()

myDS2.show()

peopleDS.show()
