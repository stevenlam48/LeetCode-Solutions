package surroundedRegionsOld

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SurroundedRegionsTest {
    private val solution = Solution()

    @Test
    fun testExample() {
        val board = arrayOf(
            charArrayOf('X', 'X', 'X', 'X'),
            charArrayOf('X', 'O', 'O', 'X'),
            charArrayOf('X', 'X', 'O', 'X'),
            charArrayOf('X', 'O', 'X', 'X')
        )
        solution.solve(board)
        val expected = arrayOf(
            charArrayOf('X', 'X', 'X', 'X'),
            charArrayOf('X', 'X', 'X', 'X'),
            charArrayOf('X', 'X', 'X', 'X'),
            charArrayOf('X', 'O', 'X', 'X')
        )
        assertArrayEquals(expected, board)
    }

    @Test
    fun testSingleCell() {
        val board = arrayOf(charArrayOf('O'))
        solution.solve(board)
        assertArrayEquals(arrayOf(charArrayOf('O')), board)
    }

    @Test
    fun testAllOpen() {
        val board = arrayOf(
            charArrayOf('O', 'O', 'O'),
            charArrayOf('O', 'O', 'O'),
            charArrayOf('O', 'O', 'O')
        )
        solution.solve(board)
        val expected = arrayOf(
            charArrayOf('O', 'O', 'O'),
            charArrayOf('O', 'O', 'O'),
            charArrayOf('O', 'O', 'O')
        )
        assertArrayEquals(expected, board)
    }

    @Test
    fun testEmpty() {
        val board = arrayOf<CharArray>()
        solution.solve(board)
        assertEquals(0, board.size)
    }

    @Test
    fun testEnclosedCenter() {
        val board = arrayOf(
            charArrayOf('X', 'X', 'X'),
            charArrayOf('X', 'O', 'X'),
            charArrayOf('X', 'X', 'X')
        )
        solution.solve(board)
        val expected = arrayOf(
            charArrayOf('X', 'X', 'X'),
            charArrayOf('X', 'X', 'X'),
            charArrayOf('X', 'X', 'X')
        )
        assertArrayEquals(expected, board)
    }
}
