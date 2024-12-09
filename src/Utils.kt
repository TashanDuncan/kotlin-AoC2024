import java.io.File

fun readInput(fileName: String): List<String> {
    return File("src/main/resources", fileName).readLines()
}