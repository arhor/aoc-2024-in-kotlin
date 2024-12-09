import java.nio.file.Paths
import kotlin.io.path.useLines

fun <T> readingInput(name: String, action: (String) -> T): List<T> =
    Paths.get("src", name)
         .useLines { it.map(action).toList() }

fun Any?.println() = println(this)
