package determinethewinnerofabowlinggame

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DetermineTheWinnerOfABowlingGameTest {
    private val solution = Solution()

    @Test
    fun playerOneWinsFirstExample() {
        assertEquals(
            1,
            solution.isWinner(intArrayOf(5, 10, 3, 2), intArrayOf(6, 5, 7, 3))
        )
    }

    @Test
    fun playerTwoWinsSecondExample() {
        assertEquals(
            2,
            solution.isWinner(intArrayOf(3, 5, 7, 6), intArrayOf(8, 10, 10, 2))
        )
    }

    @Test
    fun equalScoresAreADraw() {
        assertEquals(0, solution.isWinner(intArrayOf(2, 3), intArrayOf(4, 1)))
    }

    @Test
    fun strikeBonusExpiresAfterTwoTurns() {
        assertEquals(
            0,
            solution.isWinner(intArrayOf(10, 1, 1, 9), intArrayOf(9, 9, 4, 1))
        )
    }

    @Test
    fun emptyGamesAreADraw() {
        assertEquals(0, solution.isWinner(intArrayOf(), intArrayOf()))
    }
}
