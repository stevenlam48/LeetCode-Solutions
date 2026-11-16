package fizzbuzzmultithreaded

import java.util.Collections
import kotlin.concurrent.thread
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test

class FizzBuzzMultithreadedTest {
    private fun run(n: Int): List<String> {
        val fizzBuzz = FizzBuzz(n)
        val output = Collections.synchronizedList(mutableListOf<String>())
        val threads = listOf(
            thread { fizzBuzz.fizz { output.add("fizz") } },
            thread { fizzBuzz.buzz { output.add("buzz") } },
            thread { fizzBuzz.fizzbuzz { output.add("fizzbuzz") } },
            thread { fizzBuzz.number { output.add(it.toString()) } }
        )
        for (t in threads) {
            t.join(5000)
        }
        assertFalse(threads.any { it.isAlive }, "threads did not finish")
        return output.toList()
    }

    private fun expected(n: Int): List<String> {
        return (1..n).map {
            when {
                it % 15 == 0 -> "fizzbuzz"
                it % 5 == 0 -> "buzz"
                it % 3 == 0 -> "fizz"
                else -> it.toString()
            }
        }
    }

    @Test
    fun fifteen() {
        assertEquals(expected(15), run(15))
    }

    @Test
    fun five() {
        assertEquals(expected(5), run(5))
    }

    @Test
    fun one() {
        assertEquals(expected(1), run(1))
    }

    @Test
    fun two() {
        assertEquals(expected(2), run(2))
    }
}
