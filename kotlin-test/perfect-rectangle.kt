package perfectrectangle

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PerfectRectangleTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        val rectangles = arrayOf(
            intArrayOf(0, 0, 1, 1),
            intArrayOf(0, 1, 1, 2),
            intArrayOf(1, 0, 2, 1),
            intArrayOf(1, 1, 2, 2)
        )
        assertTrue(solution.isRectangleCover(rectangles))
    }

    @Test
    fun testExample2() {
        val rectangles = arrayOf(
            intArrayOf(1, 1, 2, 3),
            intArrayOf(1, 3, 2, 4),
            intArrayOf(3, 1, 4, 2),
            intArrayOf(3, 2, 4, 4)
        )
        assertFalse(solution.isRectangleCover(rectangles))
    }

    @Test
    fun testExample3() {
        val rectangles = arrayOf(
            intArrayOf(1, 1, 3, 3),
            intArrayOf(3, 1, 4, 2),
            intArrayOf(1, 3, 2, 4),
            intArrayOf(2, 2, 4, 4)
        )
        assertFalse(solution.isRectangleCover(rectangles))
    }

    @Test
    fun testSingleRectangle() {
        val rectangles = arrayOf(intArrayOf(0, 0, 1, 1))
        assertTrue(solution.isRectangleCover(rectangles))
    }
}
