package maximumpointsinsidethesquare

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MaximumPointsInsideTheSquareTest {
    @Test
    fun firstExample() {
        val points = arrayOf(intArrayOf(1, 1), intArrayOf(-2, -2), intArrayOf(-1, -1))
        assertEquals(2, Solution().maxPointsInsideSquare(points, "abb"))
    }

    @Test
    fun laterDuplicateCanAllowSmallerPoints() {
        val points = arrayOf(intArrayOf(1, 1), intArrayOf(-1, -1), intArrayOf(2, -2))
        assertEquals(2, Solution().maxPointsInsideSquare(points, "abb"))
    }

    @Test
    fun distinctTags() {
        val points = arrayOf(intArrayOf(2, 2), intArrayOf(-1, -2), intArrayOf(-4, 4))
        assertEquals(3, Solution().maxPointsInsideSquare(points, "abc"))
    }

    @Test
    fun pointAtOrigin() {
        assertEquals(1, Solution().maxPointsInsideSquare(arrayOf(intArrayOf(0, 0)), "a"))
    }
}
