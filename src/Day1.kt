fun main() {
    val inputFileName = "day1.txt"
    val exampleInputFileName = "day1_example.txt"
    val locationIDList1 = mutableListOf<Int>()
    val locationIDList2 = mutableListOf<Int>()

    val input = readInput(inputFileName)

    val newInput = input.map { it.split(Regex("\\s+")).filter { it.isNotBlank() } }

    for (id in newInput) {
        locationIDList1.add(id[0].toInt())
        locationIDList2.add(id[1].toInt())
    }

    val sortedLocationIDList1 = locationIDList1.sorted()
    val sortedLocationIDList2 = locationIDList2.sorted()




    val part1Result = sortedLocationIDList1.zip(sortedLocationIDList2) // Pairs the two lists
        .map { (a, b) -> kotlin.math.abs(a - b) } // Calculate absolute differences
        .sum() // Sum all the differences

    val part2Result = sortedLocationIDList1.sumOf { number ->
        val count = sortedLocationIDList2.count { it == number } // Count occurrences of the number in list2
        number * count // Multiply the number by its count
    }

    // Print the processed input
    println("Processed input:")
    println("part1: $part1Result")
    println("part2: $part2Result")
}