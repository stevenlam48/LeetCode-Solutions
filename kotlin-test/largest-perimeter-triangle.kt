package largestperimetertriangle

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LargestPerimeterTriangleTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(5, solution.largestPerimeter(intArrayOf(2, 1, 2)))
    }

    @Test
    fun testExample2() {
        assertEquals(0, solution.largestPerimeter(intArrayOf(1, 2, 1)))
    }

    @Test
    fun testExample3() {
        assertEquals(8, solution.largestPerimeter(intArrayOf(3, 6, 2, 3)))
    }

    @Test
    fun testEquilateral() {
        assertEquals(3, solution.largestPerimeter(intArrayOf(1, 1, 1)))
    }

    @Test
    fun testTooFewElements() {
        assertEquals(0, solution.largestPerimeter(intArrayOf(1, 2)))
    }
}
