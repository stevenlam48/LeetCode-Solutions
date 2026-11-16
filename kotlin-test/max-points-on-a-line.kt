package maxpointsonaline

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaxPointsOnALineTest {
    private val solution = Solution()

    @Test
    fun computesFirstExample() {
        val points = pointsOf(1 to 1, 2 to 2, 3 to 3)
        assertEquals(3, solution.maxPoints(points))
    }

    @Test
    fun computesSecondExample() {
        val points = pointsOf(1 to 1, 3 to 2, 5 to 3, 4 to 1, 2 to 3, 1 to 4)
        assertEquals(4, solution.maxPoints(points))
    }

    @Test
    fun countsDuplicatePoints() {
        val points = pointsOf(1 to 1, 1 to 1, 2 to 2, 2 to 2)
        assertEquals(4, solution.maxPoints(points))
    }

    @Test
    fun countsVerticalLine() {
        val points = pointsOf(2 to 0, 2 to 1, 2 to 4, 1 to 3)
        assertEquals(3, solution.maxPoints(points))
    }

    @Test
    fun handlesSinglePoint() {
        assertEquals(1, solution.maxPoints(pointsOf(7 to -2)))
    }

    @Test
    fun handlesEmptyInput() {
        assertEquals(0, solution.maxPoints(arrayOf()))
    }

    private fun pointsOf(vararg coordinates: Pair<Int, Int>): Array<Point> {
        return coordinates.map { Point(it.first, it.second) }.toTypedArray()
    }
}
