package maximumpathintersectionsuminagrid

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MaximumPathIntersectionSumInAGridTest {
    @Test
    fun twoByTwoGrid() {
        val grid = arrayOf(intArrayOf(1, 2), intArrayOf(3, 4))
        assertEquals(7, Solution().maxScore(grid))
    }

    @Test
    fun negativeTwoByTwoGrid() {
        val grid = arrayOf(intArrayOf(-5, -2), intArrayOf(-3, -4))
        assertEquals(-6, Solution().maxScore(grid))
    }

    @Test
    fun interiorCellCanBeBest() {
        val grid = arrayOf(intArrayOf(-9, -8, -7), intArrayOf(-6, -1, -2), intArrayOf(-3, -4, -5))
        assertEquals(-1, Solution().maxScore(grid))
    }

    @Test
    fun positiveRowPath() {
        val grid = arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9))
        assertEquals(24, Solution().maxScore(grid))
    }
}
