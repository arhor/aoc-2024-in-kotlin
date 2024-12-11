fun main() {
    val input = readingInput("Day02.txt") { line ->
        line.split(" ")
            .map { it.toInt() }
    }

    part1(input).println()
    part2(input).println()
}

private fun part1(data: List<List<Int>>): Int =
    data.count { it.isSafe() }

private fun part2(data: List<List<Int>>): Int =
    data.count { it.isSafe() || it.indices.any { i -> it.dropAt(i).isSafe() } }

private val SAFE_DIFF = 1..3

private fun List<Int>.isSafe() = zipWithNext().run {
    (allIncreasing || allDecreasing) && all { (p, n) -> diff(p, n) in SAFE_DIFF }
}
