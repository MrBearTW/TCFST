// Read input file
val input = sc.textFile("input.txt")
// Split into words and remove empty lines
val tokenized = input.map(line => line.split(" "))
    .filter(words => words.size > 0)
// Extract the first word from each line (the log level) and do a count
val counts = tokenized.map(words => (words(0), 1))
    .reduceByKey{ (a, b) => a + b }
counts.collect()
counts.collect()
