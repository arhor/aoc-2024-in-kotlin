fun main() {
    val input = readingInput("Day02.txt") { line ->
        line.split(" ")
            .map { it.toInt() }
    }

    part1(input).println()
    part2(input).println()
}

private fun part1(data: List<List<Int>>): Int =
    data.count { isSafe(it) }

private fun part2(data: List<List<Int>>): Int =
    data.count { isSafe(it) || it.indices.any { index -> isSafe(it.toMutableList().apply { removeAt(index) }) } }

private val SAFE_DIFF = 1..3

private fun isSafe(list: List<Int>) = list.zipWithNext().run {
    (increasing || decreasing) && all { (p, n) -> diff(p, n) in SAFE_DIFF }
}
