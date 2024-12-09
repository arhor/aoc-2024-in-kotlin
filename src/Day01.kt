import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.abs

fun main() {
    val input = readingInput("Day01.txt") { line ->
        line.split("   ")
            .let { (l, r) -> l.toInt() to r.toInt() }
    }

    part1(input).println()
    part2(input).println()
}

private fun part1(input: List<Pair<Int, Int>>): Int {
    val one = PriorityQueue<Int>()
    val two = PriorityQueue<Int>()

    input.forEach { (l, r) ->
        one += l
        two += r
    }
    var result = 0
    while (one.isNotEmpty() && two.isNotEmpty()) {
        val l = one.poll()
        val r = two.poll()

        result += abs(l - r)
    }
    return result
}

private fun part2(input: List<Pair<Int, Int>>): Int {
    val one = ArrayList<Int>()
    val two = HashMap<Int, Int>().withDefault { 0 }

    input.forEach { (l, r) ->
        one += l
        two.merge(r, 1, Int::plus)
    }
    return one.sumOf { it * two.getValue(it) }
}
