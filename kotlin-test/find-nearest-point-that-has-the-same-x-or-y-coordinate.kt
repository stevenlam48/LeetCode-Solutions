package findnearestpointthathasthesamexorycoordinate

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindNearestPointThatHasTheSameXOrYCoordinateTest {
    private val solution = Solution()

    @Test
    fun exampleOne() {
        val points = arrayOf(intArrayOf(1, 2), intArrayOf(3, 1), intArrayOf(2, 4), intArrayOf(2, 3), intArrayOf(4, 4))
        assertEquals(2, solution.nearestValidPoint(3, 4, points))
    }

    @Test
    fun exampleTwo() {
        assertEquals(0, solution.nearestValidPoint(3, 4, arrayOf(intArrayOf(3, 4))))
    }

    @Test
    fun exampleNoValidPoint() {
        assertEquals(-1, solution.nearestValidPoint(3, 4, arrayOf(intArrayOf(2, 3))))
    }

    @Test
    fun tiesUseSmallestIndex() {
        val points = arrayOf(intArrayOf(2, 3), intArrayOf(0, 3), intArrayOf(1, 2), intArrayOf(1, 4))
        assertEquals(0, solution.nearestValidPoint(1, 3, points))
    }
}
