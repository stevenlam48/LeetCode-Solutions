package rectangleareaii

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RectangleAreaIITest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        val rectangles = arrayOf(
            intArrayOf(0, 0, 2, 2),
            intArrayOf(1, 0, 2, 3),
            intArrayOf(1, 0, 3, 1)
        )
        assertEquals(6, solution.rectangleArea(rectangles))
    }

    @Test
    fun testExample2() {
        val rectangles = arrayOf(intArrayOf(0, 0, 1000000000, 1000000000))
        assertEquals(49, solution.rectangleArea(rectangles))
    }

    @Test
    fun testDisjoint() {
        val rectangles = arrayOf(
            intArrayOf(0, 0, 1, 1),
            intArrayOf(2, 2, 3, 3)
        )
        assertEquals(2, solution.rectangleArea(rectangles))
    }

    @Test
    fun testSingleRectangle() {
        val rectangles = arrayOf(intArrayOf(0, 0, 3, 4))
        assertEquals(12, solution.rectangleArea(rectangles))
    }

    @Test
    fun testFullyContained() {
        val rectangles = arrayOf(
            intArrayOf(0, 0, 10, 10),
            intArrayOf(2, 2, 3, 3)
        )
        assertEquals(100, solution.rectangleArea(rectangles))
    }

    @Test
    fun testOverlappingPair() {
        val rectangles = arrayOf(
            intArrayOf(0, 0, 2, 2),
            intArrayOf(1, 1, 3, 3)
        )
        assertEquals(7, solution.rectangleArea(rectangles))
    }
}
