case class Flight(dofM: Int, dofW: String, carrier: String, tailnum: String, flnum: Int, org_id: String, origin: String, dest_id: String, dest: String, crsdeptime: Double, deptime: Double, depdelaymins: Double, crsarrtime: Double, arrtime: Double, arrdelay: Double, crselapsedtime: Double, dist: Int)

def parseFlight(str: String): Flight = {
    val line = str.split(",")
    Flight(line(0).toInt, line(1), line(2), line(3), line(4).toInt, line(5), line(6), line(7), line(8), line(9).toDouble, line(10).toDouble, line(11).toDouble, line(12).toDouble, line(13).toDouble, line(14).toDouble, line(15).toDouble, line(16).toInt)
}

val dataFile = "test-02/flights.csv"
val outPath = "test-02/output"

val textRDD = sc.textFile( dataFile )
val header=textRDD.first

val flightsRDD = textRDD.filter(x => x != header).map(parseFlight).cache()

val delayedArrRDD = flightsRDD.filter(p => p.dest == "ANC").filter(x => x.depdelaymins > 40)
val delayedDepRDD = flightsRDD.filter(p => p.origin == "ANC").filter(x => x.depdelaymins > 40)
val delayedRDD = delayedArrRDD.union(delayedDepRDD)

val sumRDD = delayedRDD.map(flight=>(flight.dofM, flight.depdelaymins)).reduceByKey( (x,y) => x + y )
val cntRDD = delayedRDD.map(flight=>(flight.dofM, 1)).reduceByKey( (x,y) => x + y )
val joinRDD = cntRDD.join(sumRDD)
val resultRDD = joinRDD.map(delayed => ( delayed._1, (delayed._2._1, delayed._2._2, delayed._2._2 / delayed._2._1)))
val partRDD = resultRDD.coalesce(1).sortBy( result => result._1 )
partRDD.saveAsTextFile( outPath )

