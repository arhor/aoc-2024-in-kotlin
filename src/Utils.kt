import java.nio.file.Paths
import kotlin.io.path.useLines
import kotlin.math.abs

fun <T> readingInput(name: String, action: (String) -> T): List<T> =
    Paths.get("src", name).useLines { it.map(action).toList() }

fun Any?.println() = println(this)

fun diff(a: Int, b: Int): Int = abs(abs(a) - abs(b))

val <T : Comparable<T>> List<Pair<T, T>>.increasing: Boolean
    get() = all { (a, b) -> a > b }

val <T : Comparable<T>> List<Pair<T, T>>.decreasing: Boolean
    get() = all { (a, b) -> a < b }
