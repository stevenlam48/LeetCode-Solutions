package candycrush

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CandyCrushTest {
    private val solution = Solution()

    @Test
    fun testFullRowsCrushed() {
        val board = arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(2, 2, 2),
            intArrayOf(3, 3, 3)
        )
        val expected = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(0, 0, 0),
            intArrayOf(0, 0, 0)
        )
        assertBoardEquals(expected, solution.candyCrush(board))
    }

    @Test
    fun testColumnCrushAndGravity() {
        val board = arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(1, 2, 2),
            intArrayOf(1, 2, 2)
        )
        val expected = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(0, 2, 2),
            intArrayOf(0, 2, 2)
        )
        assertBoardEquals(expected, solution.candyCrush(board))
    }

    @Test
    fun testVerticalCrush() {
        val board = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(1, 2, 3),
            intArrayOf(1, 2, 3)
        )
        val expected = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(0, 0, 0),
            intArrayOf(0, 0, 0)
        )
        assertBoardEquals(expected, solution.candyCrush(board))
    }

    @Test
    fun testNoCrush() {
        val board = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(3, 4)
        )
        val expected = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(3, 4)
        )
        assertBoardEquals(expected, solution.candyCrush(board))
    }

    private fun assertBoardEquals(expected: Array<IntArray>, actual: Array<IntArray>) {
        assertEquals(expected.size, actual.size)
        for (i in expected.indices) {
            assertArrayEquals(expected[i], actual[i])
        }
    }
}
