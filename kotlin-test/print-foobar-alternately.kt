package printfoobaralternately

import java.util.Collections
import kotlin.concurrent.thread
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test

class PrintFoobarAlternatelyTest {
    private fun run(n: Int): List<String> {
        val fooBar = FooBar(n)
        val output = Collections.synchronizedList(mutableListOf<String>())
        val fooThread = thread { fooBar.foo { output.add("foo") } }
        val barThread = thread { fooBar.bar { output.add("bar") } }
        fooThread.join(5000)
        barThread.join(5000)
        assertFalse(fooThread.isAlive, "foo thread did not finish")
        assertFalse(barThread.isAlive, "bar thread did not finish")
        return output.toList()
    }

    private fun expected(n: Int): List<String> = (1..n).flatMap { listOf("foo", "bar") }

    @Test
    fun one() {
        assertEquals(expected(1), run(1))
    }

    @Test
    fun two() {
        assertEquals(expected(2), run(2))
    }

    @Test
    fun five() {
        assertEquals(expected(5), run(5))
    }

    @Test
    fun twenty() {
        assertEquals(expected(20), run(20))
    }
}
