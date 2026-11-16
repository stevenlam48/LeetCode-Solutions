package findwinneronatictactoegame

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindWinnerOnATicTacToeGameTest {
    @Test
    fun playerAWins() {
        val moves = arrayOf(
            intArrayOf(0, 0), intArrayOf(2, 0), intArrayOf(1, 1),
            intArrayOf(2, 1), intArrayOf(2, 2)
        )
        assertEquals("A", Solution().tictactoe(moves))
    }

    @Test
    fun playerBWins() {
        val moves = arrayOf(
            intArrayOf(0, 0), intArrayOf(1, 1), intArrayOf(0, 1),
            intArrayOf(0, 2), intArrayOf(1, 0), intArrayOf(2, 0)
        )
        assertEquals("B", Solution().tictactoe(moves))
    }

    @Test
    fun draw() {
        val moves = arrayOf(
            intArrayOf(0, 0), intArrayOf(1, 1), intArrayOf(2, 0),
            intArrayOf(1, 0), intArrayOf(1, 2), intArrayOf(0, 1),
            intArrayOf(0, 2), intArrayOf(2, 2), intArrayOf(2, 1)
        )
        assertEquals("Draw", Solution().tictactoe(moves))
    }

    @Test
    fun pending() {
        assertEquals("Pending", Solution().tictactoe(arrayOf(intArrayOf(0, 0), intArrayOf(1, 1))))
    }
}
