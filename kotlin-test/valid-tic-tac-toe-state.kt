package validtictactoestate

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ValidTicTacToeStateTest {
    @Test
    fun leetCodeInvalidExample() {
        assertFalse(Solution().validTicTacToe(listOf("O  ", "   ", "   ")))
    }

    @Test
    fun leetCodeValidExample() {
        assertTrue(Solution().validTicTacToe(listOf("XOX", "O O", "XOX")))
    }

    @Test
    fun bothPlayersWin() {
        assertFalse(Solution().validTicTacToe(listOf("OOO", "XXX", "   ")))
    }

    @Test
    fun xWinsButCountsMismatch() {
        assertFalse(Solution().validTicTacToe(listOf("XXX", "XOO", "OO ")))
    }

    @Test
    fun firstMoveOnly() {
        assertTrue(Solution().validTicTacToe(listOf("X  ", "   ", "   ")))
    }

    @Test
    fun emptyBoard() {
        assertTrue(Solution().validTicTacToe(listOf("   ", "   ", "   ")))
    }
}
