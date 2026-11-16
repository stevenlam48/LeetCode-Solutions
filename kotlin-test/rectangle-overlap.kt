package rectangleoverlap

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RectangleOverlapTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertTrue(solution.isRectangleOverlap(intArrayOf(0, 0, 2, 2), intArrayOf(1, 1, 3, 3)))
    }

    @Test
    fun testExample2() {
        assertFalse(solution.isRectangleOverlap(intArrayOf(0, 0, 1, 1), intArrayOf(1, 0, 2, 1)))
    }

    @Test
    fun testExample3() {
        assertFalse(solution.isRectangleOverlap(intArrayOf(0, 0, 1, 1), intArrayOf(2, 2, 3, 3)))
    }

    @Test
    fun testContained() {
        assertTrue(solution.isRectangleOverlap(intArrayOf(0, 0, 4, 4), intArrayOf(1, 1, 2, 2)))
    }

    @Test
    fun testTouchingHorizontally() {
        assertFalse(solution.isRectangleOverlap(intArrayOf(0, 0, 1, 1), intArrayOf(1, 1, 2, 2)))
    }

    @Test
    fun testOverlapOnOneAxisOnly() {
        assertFalse(solution.isRectangleOverlap(intArrayOf(0, 0, 2, 1), intArrayOf(1, 1, 3, 3)))
    }
}
