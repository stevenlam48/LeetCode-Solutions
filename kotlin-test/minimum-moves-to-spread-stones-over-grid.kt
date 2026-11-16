package minimummovestospreadstonesovergrid

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumMovesToSpreadStonesOverGridTest {
    private val solution = Solution()

    @Test
    fun balancedGridNeedsNoMoves() {
        val grid = arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(1, 1, 1),
            intArrayOf(1, 1, 1)
        )
        assertEquals(0, solution.minimumMoves(grid))
    }

    @Test
    fun adjacentStoneMovesOnce() {
        val grid = arrayOf(
            intArrayOf(2, 0, 1),
            intArrayOf(1, 1, 1),
            intArrayOf(1, 1, 1)
        )
        assertEquals(1, solution.minimumMoves(grid))
    }

    @Test
    fun movesStoneAcrossGrid() {
        val grid = arrayOf(
            intArrayOf(1, 1, 0),
            intArrayOf(1, 1, 1),
            intArrayOf(1, 2, 1)
        )
        assertEquals(3, solution.minimumMoves(grid))
    }

    @Test
    fun matchesMultipleSourcesAndDestinations() {
        val grid = arrayOf(
            intArrayOf(2, 0, 2),
            intArrayOf(0, 1, 1),
            intArrayOf(1, 1, 1)
        )
        assertEquals(2, solution.minimumMoves(grid))
    }
}
