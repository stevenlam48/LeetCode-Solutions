package solveSudoku

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SolveSudokuTest {
    @Test
    fun standardPuzzle() {
        val board = arrayOf(
            "53..7....".toCharArray(),
            "6..195...".toCharArray(),
            ".98....6.".toCharArray(),
            "8...6...3".toCharArray(),
            "4..8.3..1".toCharArray(),
            "7...2...6".toCharArray(),
            ".6....28.".toCharArray(),
            "...419..5".toCharArray(),
            "....8..79".toCharArray()
        )
        val expected = listOf(
            "534678912",
            "672195348",
            "198342567",
            "859761423",
            "426853791",
            "713924856",
            "961537284",
            "287419635",
            "345286179"
        )
        Solution().solveSudoku(board)
        assertEquals(expected, board.map { String(it) })
    }

    @Test
    fun nearlySolvedBoard() {
        val board = arrayOf(
            "534678912".toCharArray(),
            "672195348".toCharArray(),
            "198342567".toCharArray(),
            "859761423".toCharArray(),
            "426853791".toCharArray(),
            "713924856".toCharArray(),
            "961537284".toCharArray(),
            "287419635".toCharArray(),
            "345286179".toCharArray()
        )
        val expected = board.map { String(it) }
        Solution().solveSudoku(board)
        assertEquals(expected, board.map { String(it) })
    }

    @Test
    fun singleMissingCell() {
        val board = arrayOf(
            "534678912".toCharArray(),
            "672195348".toCharArray(),
            "198342567".toCharArray(),
            "859761423".toCharArray(),
            "426853791".toCharArray(),
            "713924856".toCharArray(),
            "961537284".toCharArray(),
            "287419635".toCharArray(),
            "34528617.".toCharArray()
        )
        Solution().solveSudoku(board)
        assertEquals("345286179", String(board[8]))
    }
}
