package superpow

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SuperPowTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(8, solution.superPow(2, intArrayOf(3)))
    }

    @Test
    fun testExample2() {
        assertEquals(1024, solution.superPow(2, intArrayOf(1, 0)))
    }

    @Test
    fun testExample3() {
        assertEquals(1, solution.superPow(1, intArrayOf(4, 3, 3, 8, 5, 2)))
    }

    @Test
    fun testLargeBase() {
        assertEquals(1198, solution.superPow(2147483647, intArrayOf(2, 0, 0)))
    }

    @Test
    fun testZeroExponent() {
        assertEquals(1, solution.superPow(5, intArrayOf(0)))
    }
}
