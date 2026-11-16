package gameoflife

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GameOfLifeTest {
    private fun assertBoard(expected: Array<IntArray>, actual: Array<IntArray>) {
        assertEquals(expected.size, actual.size)
        for (i in expected.indices) {
            assertArrayEquals(expected[i], actual[i])
        }
    }

    @Test
    fun example1() {
        val board = arrayOf(
            intArrayOf(0, 1, 0),
            intArrayOf(0, 0, 1),
            intArrayOf(1, 1, 1),
            intArrayOf(0, 0, 0)
        )
        val expected = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(1, 0, 1),
            intArrayOf(0, 1, 1),
            intArrayOf(0, 1, 0)
        )
        Solution().gameOfLife(board)
        assertBoard(expected, board)
    }

    @Test
    fun example2() {
        val board = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(1, 0)
        )
        val expected = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(1, 1)
        )
        Solution().gameOfLife(board)
        assertBoard(expected, board)
    }

    @Test
    fun singleLiveCellDies() {
        val board = arrayOf(intArrayOf(1))
        Solution().gameOfLife(board)
        assertBoard(arrayOf(intArrayOf(0)), board)
    }

    @Test
    fun singleDeadCellStaysDead() {
        val board = arrayOf(intArrayOf(0))
        Solution().gameOfLife(board)
        assertBoard(arrayOf(intArrayOf(0)), board)
    }

    @Test
    fun emptyBoard() {
        val board = arrayOf<IntArray>()
        Solution().gameOfLife(board)
        assertEquals(0, board.size)
    }
}
