package findpolygonwiththelargestperimeter

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindPolygonWithTheLargestPerimeterTest {
    @Test
    fun testExample1() {
        assertEquals(15L, Solution().largestPerimeter(intArrayOf(5, 5, 5)))
    }

    @Test
    fun testExample2() {
        assertEquals(12L, Solution().largestPerimeter(intArrayOf(1, 12, 1, 2, 5, 50, 3)))
    }

    @Test
    fun testNoValidPolygon() {
        assertEquals(-1L, Solution().largestPerimeter(intArrayOf(5, 5, 50)))
    }

    @Test
    fun testAllEqual() {
        assertEquals(4L, Solution().largestPerimeter(intArrayOf(1, 1, 1, 1)))
    }

    @Test
    fun testLargeValues() {
        assertEquals(
            3_000_000_001L,
            Solution().largestPerimeter(intArrayOf(1_000_000_000, 1_000_000_000, 1_000_000_000, 1))
        )
    }
}
