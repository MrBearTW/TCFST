val file = sc.textFile("/usr/local/spark-2.2.0-bin-hadoop2.7/README.md")

// Create an Accumulator[Int] initialized to 0
val blankLines = sc.accumulator(0) 

val callSigns = file.flatMap(line => {
  if (line == "") {
    blankLines += 1 // Add to the accumulator
  }
  line.split(" ")
})

callSigns.saveAsTextFile("src/output.txt")

println("Blank lines: " + blankLines.value)
