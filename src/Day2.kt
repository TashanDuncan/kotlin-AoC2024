fun main() {
    val inputFileName = "day2.txt"
    val exampleInputFileName = "day2_example.txt"

    val input = readInput(inputFileName).map { it.split(" ").map { it.toInt() } }

    val safeReportsCount = input.count { isSafe(it) }
    val safeReportsCountWithDampener = input.count { isSafeWithDampener(it) }

    println("Number of safe reports: $safeReportsCount")
    println("Number of safe reports (with Dampener): $safeReportsCountWithDampener")
}

fun isSafe(report: List<Int>): Boolean {
    val differences = report.zipWithNext { a, b -> b - a }

    val isIncreasing = differences.all { it in 1..3 }
    val isDecreasing = differences.all { it in -3..-1 }

    return isIncreasing || isDecreasing
}

fun isSafeWithDampener(report: List<Int>): Boolean {
    if (isSafe(report)) return true // Already safe without modification

    // Try removing each level and check if it becomes safe
    for (i in report.indices) {
        val modifiedReport = report.toMutableList().apply { removeAt(i) }
        if (isSafe(modifiedReport)) return true
    }

    return false // Not safe even with the Dampener
}




