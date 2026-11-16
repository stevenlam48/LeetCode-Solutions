package findthenumberofwinningplayers

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FindTheNumberOfWinningPlayersTest {
    private val solution = Solution()

    @Test
    fun playerMustExceedTheirIndexWithOneColor() {
        val pick = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(1, 0),
            intArrayOf(1, 0),
            intArrayOf(2, 1),
            intArrayOf(2, 1),
            intArrayOf(2, 0),
        )
        assertEquals(2, solution.winningPlayerCount(4, pick))
    }

    @Test
    fun totalBallsDoNotMatterWhenColorsDiffer() {
        val pick = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(1, 2),
            intArrayOf(1, 3),
            intArrayOf(1, 4),
        )
        assertEquals(0, solution.winningPlayerCount(5, pick))
    }

    @Test
    fun allPickingPlayersCanWin() {
        val pick = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(1, 1),
            intArrayOf(1, 1),
            intArrayOf(2, 2),
            intArrayOf(2, 2),
            intArrayOf(2, 2),
        )
        assertEquals(3, solution.winningPlayerCount(5, pick))
    }

    @Test
    fun playersWithoutPicksCannotWin() {
        val pick = arrayOf(
            intArrayOf(0, 4),
            intArrayOf(3, 2),
            intArrayOf(3, 2),
            intArrayOf(3, 2),
            intArrayOf(3, 2),
        )
        assertEquals(2, solution.winningPlayerCount(6, pick))
    }

    @Test
    fun noPicksMeansNoWinners() {
        assertEquals(0, solution.winningPlayerCount(0, emptyArray()))
    }
}
