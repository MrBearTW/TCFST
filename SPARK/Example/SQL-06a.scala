import org.apache.spark.sql.types._

val mySchema = 
  StructType(
    StructField("name", StringType, true) ::
    StructField("score", IntegerType, true) :: Nil
  )

val peopleDF = spark.read
  .schema(mySchema)
  .option("header", "false")
  .option("inferSchema", "true")
  .csv("Example/people.txt")

peopleDF.createOrReplaceTempView("people")

val results = spark.sql("SELECT name, score FROM people")

results.show()
