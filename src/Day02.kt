fun main() {
    val input = readingInput("Day02.txt") { line ->
        line.split(" ")
            .map { it.toInt() }
    }

    part1(input).println()
    part2(input).println()
}

private fun part1(data: List<List<Int>>) = data.count { it.safe }
private fun part2(data: List<List<Int>>) = data.count { it.safe || it.indices.any { i -> it.dropAt(i).safe } }

private val List<Int>.safe get() = zipWithNext().let { (it.allIncreasing || it.allDecreasing) && it.diffGradually }
private val List<Pair<Int, Int>>.allIncreasing get() = all { (a, b) -> a > b }
private val List<Pair<Int, Int>>.allDecreasing get() = all { (a, b) -> a < b }
private val List<Pair<Int, Int>>.diffGradually get() = all { (a, b) -> diff(a, b) in 1..3 }
