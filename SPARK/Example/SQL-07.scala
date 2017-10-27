val jdbcDF = spark.read.format("jdbc")
  .option("url", "jdbc:postgresql://localhost/root")
  .option("dbtable", "flightdelay")
  .option("user", "root")
  .option("password", "123456")
  .load()

jdbcDF.show()
