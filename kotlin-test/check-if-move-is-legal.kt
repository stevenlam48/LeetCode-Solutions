package checkifmoveislegal

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CheckIfMoveIsLegalTest {
    private val solution = Solution()

    @Test
    fun legalHorizontalMove() {
        val board = boardOf(Triple(3, 4, 'B'), Triple(3, 5, 'W'))
        assertTrue(solution.checkMove(board, 3, 3, 'W'))
    }

    @Test
    fun emptyBoardHasNoLegalLine() {
        assertFalse(solution.checkMove(boardOf(), 3, 3, 'W'))
    }

    @Test
    fun lineNeedsTwoOtherCells() {
        val board = boardOf(Triple(3, 4, 'B'))
        assertFalse(solution.checkMove(board, 3, 3, 'W'))
    }

    @Test
    fun legalDiagonalMove() {
        val board = boardOf(Triple(1, 1, 'W'), Triple(2, 2, 'B'))
        assertTrue(solution.checkMove(board, 0, 0, 'B'))
    }

    @Test
    fun adjacentSameColorCannotStartLine() {
        val board = boardOf(Triple(3, 4, 'W'), Triple(3, 5, 'B'))
        assertFalse(solution.checkMove(board, 3, 3, 'W'))
    }
}

private fun boardOf(vararg cells: Triple<Int, Int, Char>): Array<CharArray> {
    val board = Array(8) { CharArray(8) { '.' } }
    for ((r, c, color) in cells) {
        board[r][c] = color
    }
    return board
}
