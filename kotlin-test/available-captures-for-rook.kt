package availablecapturesforrook

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class AvailableCapturesForRookTest {
    private val solution = Solution()

    private fun emptyBoard(): Array<CharArray> = Array(8) { CharArray(8) { '.' } }

    @Test
    fun testExample() {
        val board = arrayOf(
            charArrayOf('.', '.', '.', '.', '.', '.', '.', '.'),
            charArrayOf('.', '.', '.', 'p', '.', '.', '.', '.'),
            charArrayOf('.', '.', '.', 'R', '.', '.', '.', 'p'),
            charArrayOf('.', '.', '.', '.', '.', '.', '.', '.'),
            charArrayOf('.', '.', '.', '.', '.', '.', '.', '.'),
            charArrayOf('.', '.', '.', 'p', '.', '.', '.', '.'),
            charArrayOf('.', '.', '.', '.', '.', '.', '.', '.'),
            charArrayOf('.', '.', '.', '.', '.', '.', '.', '.')
        )
        assertEquals(3, solution.numRookCaptures(board))
    }

    @Test
    fun testNoPawns() {
        val board = emptyBoard()
        board[3][3] = 'R'
        assertEquals(0, solution.numRookCaptures(board))
    }

    @Test
    fun testBlockedByBishop() {
        val board = emptyBoard()
        board[3][3] = 'R'
        board[1][3] = 'p'
        board[5][3] = 'p'
        board[3][1] = 'p'
        board[3][5] = 'B'
        board[3][6] = 'p'
        assertEquals(3, solution.numRookCaptures(board))
    }
}
