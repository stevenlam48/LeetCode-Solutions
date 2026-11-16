package largestrectangleinhistogram

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LargestRectangleInHistogramTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(10, solution.largestRectangleArea(intArrayOf(2, 1, 5, 6, 2, 3)))
    }

    @Test
    fun testExample2() {
        assertEquals(4, solution.largestRectangleArea(intArrayOf(2, 4)))
    }

    @Test
    fun testSingleBar() {
        assertEquals(1, solution.largestRectangleArea(intArrayOf(1)))
    }

    @Test
    fun testZeroHeight() {
        assertEquals(0, solution.largestRectangleArea(intArrayOf(0)))
    }

    @Test
    fun testValley() {
        assertEquals(3, solution.largestRectangleArea(intArrayOf(2, 1, 2)))
    }
}
