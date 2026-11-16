package minimummovestoreachtargetwithrotations

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumMovesToReachTargetWithRotationsTest {
    private val solution = Solution()

    @Test
    fun reachesAdjacentGoalInTwoByTwoGrid() {
        val grid = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(0, 0)
        )
        assertEquals(1, solution.minimumMoves(grid))
    }

    @Test
    fun slidesThroughOpenGrid() {
        val grid = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(0, 0, 0),
            intArrayOf(0, 0, 0)
        )
        assertEquals(3, solution.minimumMoves(grid))
    }

    @Test
    fun navigatesObstaclesWithRotations() {
        val grid = arrayOf(
            intArrayOf(0, 0, 0, 0, 0, 1),
            intArrayOf(1, 1, 0, 0, 1, 0),
            intArrayOf(0, 0, 0, 0, 1, 1),
            intArrayOf(0, 0, 1, 0, 1, 0),
            intArrayOf(0, 1, 1, 0, 0, 0),
            intArrayOf(0, 1, 1, 0, 0, 0)
        )
        assertEquals(11, solution.minimumMoves(grid))
    }

    @Test
    fun returnsMinusOneWhenInitialPassageIsBlocked() {
        val grid = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(0, 1)
        )
        assertEquals(-1, solution.minimumMoves(grid))
    }
}
