package minesweeper

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MinesweeperTest {
    private fun boardOf(vararg rows: String): Array<CharArray> =
        rows.map { it.toCharArray() }.toTypedArray()

    private fun render(board: Array<CharArray>): List<String> =
        board.map { String(it) }

    @Test
    fun example1() {
        val board = boardOf(
            "EEEEE",
            "EEEEE",
            "EEEEE",
            "EEEEE"
        )
        board[1][2] = 'M'
        val expected = listOf(
            "B1E1B",
            "B1M1B",
            "B111B",
            "BBBBB"
        )
        assertArrayEquals(expected.toTypedArray(), render(Solution().updateBoard(board, intArrayOf(3, 0))).toTypedArray())
    }

    @Test
    fun example2() {
        val board = boardOf(
            "EEEEE",
            "EEEEE",
            "EEEEE",
            "EEEEE"
        )
        board[1][2] = 'M'
        val expected = listOf(
            "EEEEE",
            "EEXEE",
            "EEEEE",
            "EEEEE"
        )
        assertArrayEquals(expected.toTypedArray(), render(Solution().updateBoard(board, intArrayOf(1, 2))).toTypedArray())
    }

    @Test
    fun adjacentMineCounted() {
        val board = boardOf(
            "EE",
            "EM"
        )
        val expected = listOf(
            "1E",
            "EM"
        )
        assertArrayEquals(expected.toTypedArray(), render(Solution().updateBoard(board, intArrayOf(0, 0))).toTypedArray())
    }

    @Test
    fun singleMine() {
        val board = boardOf("M")
        assertArrayEquals(arrayOf("X"), render(Solution().updateBoard(board, intArrayOf(0, 0))).toTypedArray())
    }

    @Test
    fun singleEmpty() {
        val board = boardOf("E")
        assertArrayEquals(arrayOf("B"), render(Solution().updateBoard(board, intArrayOf(0, 0))).toTypedArray())
    }
}
