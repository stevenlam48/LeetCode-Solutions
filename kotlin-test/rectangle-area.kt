package rectanglearea

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RectangleAreaTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(45, solution.computeArea(-3, 0, 3, 4, 0, -1, 9, 2))
    }

    @Test
    fun testExample2() {
        assertEquals(17, solution.computeArea(-2, -2, 2, 2, 3, 3, 4, 4))
    }

    @Test
    fun testContained() {
        assertEquals(16, solution.computeArea(-2, -2, 2, 2, -1, -1, 1, 1))
    }

    @Test
    fun testDegenerate() {
        assertEquals(0, solution.computeArea(0, 0, 0, 0, 0, 0, 0, 0))
    }

    @Test
    fun testTouchingEdges() {
        assertEquals(2, solution.computeArea(0, 0, 1, 1, 1, 0, 2, 1))
    }

    @Test
    fun testLargeCoordinates() {
        assertEquals(500000000, solution.computeArea(-10000, -10000, 10000, 10000, 10000, 10000, 20000, 20000))
    }
}
