package convexpolygon

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ConvexPolygonTest {
    private val solution = Solution()

    @Test
    fun testConvexSquare() {
        val points = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(0, 1),
            intArrayOf(1, 1),
            intArrayOf(1, 0)
        )
        assertTrue(solution.isConvex(points))
    }

    @Test
    fun testNonConvex() {
        val points = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(0, 10),
            intArrayOf(10, 10),
            intArrayOf(10, 0),
            intArrayOf(5, 5)
        )
        assertFalse(solution.isConvex(points))
    }

    @Test
    fun testTriangle() {
        val points = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(1, 0),
            intArrayOf(0, 1)
        )
        assertTrue(solution.isConvex(points))
    }
}
