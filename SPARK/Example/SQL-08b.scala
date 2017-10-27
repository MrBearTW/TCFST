jdbcDF.write
  .format("jdbc")
  .mode( "append" )
  .option("url", "jdbc:postgresql://localhost/root")
  .option("dbtable", "flightdelay")
  .option("user", "root")
  .option("password", "123456")
  .save()
