package maximumnumberofintersectionsonthechart

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MaximumNumberOfIntersectionsOnTheChartTest {
    private val solution = Solution()

    @Test
    fun threeLinesOverlap() {
        assertEquals(3, solution.maxIntersectionCount(intArrayOf(1, 2, 1, 2)))
    }

    @Test
    fun strictlyIncreasingChart() {
        assertEquals(1, solution.maxIntersectionCount(intArrayOf(1, 2, 3)))
    }

    @Test
    fun horizontalChart() {
        assertEquals(3, solution.maxIntersectionCount(intArrayOf(4, 4, 4)))
    }

    @Test
    fun singlePoint() {
        assertEquals(1, solution.maxIntersectionCount(intArrayOf(7)))
    }

    @Test
    fun negativeCoordinates() {
        assertEquals(2, solution.maxIntersectionCount(intArrayOf(-2, -1, -2)))
    }
}
