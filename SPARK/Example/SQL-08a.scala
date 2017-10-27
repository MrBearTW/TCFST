// Create table and save data in PostgreSQL database
jdbcDF.write
  .format("jdbc")
  .option("url", "jdbc:postgresql://localhost/root")
  .option("dbtable", "flightdelay")
  .option("user", "root")
  .option("password", "123456")
  .save()
