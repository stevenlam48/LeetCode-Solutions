package printzeroevenodd

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTimeoutPreemptively
import org.junit.jupiter.api.Test
import java.time.Duration
import java.util.Collections
import java.util.concurrent.Callable
import java.util.concurrent.Executors

class PrintZeroEvenOddTest {
    @Test
    fun validCase1_n1() = check(1)

    @Test
    fun validCase2_n2() = check(2)

    @Test
    fun validCase3_n3() = check(3)

    @Test
    fun validCase4_n4() = check(4)

    @Test
    fun validCase5_n5() = check(5)

    @Test
    fun validCase6_n6() = check(6)

    private fun check(n: Int) = assertTimeoutPreemptively(Duration.ofSeconds(5)) {
        val expected = buildList {
            for (i in 1..n) {
                add(0)
                add(i)
            }
        }
        val actual = Collections.synchronizedList(mutableListOf<Int>())
        val zeroEvenOdd = ZeroEvenOdd(n)
        val executor = Executors.newFixedThreadPool(3)
        try {
            val tasks = listOf(
                Callable { zeroEvenOdd.zero { value -> actual.add(value) } },
                Callable { zeroEvenOdd.odd { value -> actual.add(value) } },
                Callable { zeroEvenOdd.even { value -> actual.add(value) } }
            )
            executor.invokeAll(tasks).forEach { it.get() }
        } finally {
            executor.shutdownNow()
        }
        assertEquals(expected, actual)
    }
}
