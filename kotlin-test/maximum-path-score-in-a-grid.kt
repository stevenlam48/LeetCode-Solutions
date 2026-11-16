package maximumpathscoreinagrid

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MaximumPathScoreInAGridTest {
    @Test
    fun choosesHigherScoringPath() {
        val grid = arrayOf(intArrayOf(0, 1), intArrayOf(2, 0))
        assertEquals(2, Solution().maxPathScore(grid, 1))
    }

    @Test
    fun costLimitCanMakeDestinationUnreachable() {
        val grid = arrayOf(intArrayOf(0, 1), intArrayOf(2, 0))
        assertEquals(-1, Solution().maxPathScore(grid, 0))
    }

    @Test
    fun allPositiveGrid() {
        val grid = arrayOf(intArrayOf(1, 2), intArrayOf(3, 4))
        assertEquals(-1, Solution().maxPathScore(grid, 1))
        assertEquals(7, Solution().maxPathScore(grid, 2))
    }

    @Test
    fun startingCellIsNotScored() {
        assertEquals(0, Solution().maxPathScore(arrayOf(intArrayOf(5)), 0))
    }
}
