val delayedFlights = flights
                     .select("Carrier", "DepDelayMins")
                     .filter($"DepDelayMins" > 15)

delayedFlights.show()

// Display percentage of delayed flights
val numTotalFlights = flights.count()
val numDelayedFlights = delayedFlights.count()
println("Percentage of Delayed Flights: " + (numDelayedFlights.toFloat/numTotalFlights*100) + "%")
