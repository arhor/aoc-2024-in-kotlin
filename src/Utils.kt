import java.nio.file.Paths
import kotlin.io.path.useLines
import kotlin.math.abs

fun <T> readingInput(name: String, action: (String) -> T): List<T> =
    Paths.get("src", name).useLines { it.map(action).toList() }

fun Any?.println() = println(this)

fun diff(a: Int, b: Int): Int = abs(abs(a) - abs(b))

fun <T> Collection<T>.dropAt(i: Int): List<T> = toMutableList().apply { removeAt(i) }
