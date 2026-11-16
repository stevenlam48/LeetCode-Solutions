package minimumtimevisitingallpoints

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumTimeVisitingAllPointsTest {
    @Test
    fun mixedDirections() {
        val points = arrayOf(intArrayOf(1, 1), intArrayOf(3, 4), intArrayOf(-1, 0))
        assertEquals(7, Solution().minTimeToVisitAllPoints(points))
    }

    @Test
    fun diagonalPath() {
        val points = arrayOf(intArrayOf(3, 2), intArrayOf(-2, 2))
        assertEquals(5, Solution().minTimeToVisitAllPoints(points))
    }

    @Test
    fun onePoint() {
        assertEquals(0, Solution().minTimeToVisitAllPoints(arrayOf(intArrayOf(4, 8))))
    }

    @Test
    fun duplicatePoint() {
        val points = arrayOf(intArrayOf(0, 0), intArrayOf(0, 0), intArrayOf(2, -2))
        assertEquals(2, Solution().minTimeToVisitAllPoints(points))
    }
}
