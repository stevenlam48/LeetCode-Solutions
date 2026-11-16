package fixedpoint

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FixedPointTest {
    @Test
    fun example1() {
        assertEquals(3, Solution().fixedPoint(intArrayOf(-10, -5, 0, 3, 7)))
    }

    @Test
    fun example2() {
        assertEquals(0, Solution().fixedPoint(intArrayOf(0, 2, 5, 8, 17)))
    }

    @Test
    fun noFixedPoint() {
        assertEquals(-1, Solution().fixedPoint(intArrayOf(1, 2, 3, 4, 5)))
    }

    @Test
    fun allBelowIndex() {
        assertEquals(-1, Solution().fixedPoint(intArrayOf(-1, 0, 1)))
    }

    @Test
    fun singleZero() {
        assertEquals(0, Solution().fixedPoint(intArrayOf(0)))
    }

    @Test
    fun empty() {
        assertEquals(-1, Solution().fixedPoint(intArrayOf()))
    }
}
