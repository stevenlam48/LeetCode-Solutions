package largestpositiveintegerthatexistswithitsnegative

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LargestPositiveIntegerThatExistsWithItsNegativeTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(2, solution.findMaxK(intArrayOf(1, 2, -1, -2)))
    }

    @Test
    fun testExample2() {
        assertEquals(7, solution.findMaxK(intArrayOf(-1, 10, 6, 7, -7, 1)))
    }

    @Test
    fun testNoPair() {
        assertEquals(-1, solution.findMaxK(intArrayOf(1, 2, 3)))
    }

    @Test
    fun testAllNegative() {
        assertEquals(-1, solution.findMaxK(intArrayOf(-1, -2, -3)))
    }

    @Test
    fun testSinglePair() {
        assertEquals(5, solution.findMaxK(intArrayOf(5, -5)))
    }
}
