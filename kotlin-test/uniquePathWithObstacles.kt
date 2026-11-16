package uniquePathWithObstacles

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class UniquePathWithObstaclesTest {
    @Test
    fun obstacleInCenter() {
        val grid = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(0, 1, 0),
            intArrayOf(0, 0, 0)
        )
        assertEquals(2, Solution().uniquePathsWithObstacles(grid))
    }

    @Test
    fun obstacleOnTopRow() {
        val grid = arrayOf(intArrayOf(0, 1), intArrayOf(0, 0))
        assertEquals(1, Solution().uniquePathsWithObstacles(grid))
    }

    @Test
    fun blockedStartingCell() {
        val grid = arrayOf(intArrayOf(1, 0), intArrayOf(0, 0))
        assertEquals(0, Solution().uniquePathsWithObstacles(grid))
    }

    @Test
    fun singleOpenCell() {
        assertEquals(1, Solution().uniquePathsWithObstacles(arrayOf(intArrayOf(0))))
    }
}
