package slidingpuzzle

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SlidingPuzzleTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        val board = arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 0, 5))
        assertEquals(1, solution.slidingPuzzle(board))
    }

    @Test
    fun testExample2() {
        val board = arrayOf(intArrayOf(1, 2, 3), intArrayOf(5, 4, 0))
        assertEquals(-1, solution.slidingPuzzle(board))
    }

    @Test
    fun testExample3() {
        val board = arrayOf(intArrayOf(4, 1, 2), intArrayOf(5, 0, 3))
        assertEquals(5, solution.slidingPuzzle(board))
    }

    @Test
    fun testAlreadySolved() {
        val board = arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 0))
        assertEquals(0, solution.slidingPuzzle(board))
    }

    @Test
    fun testTwoMoves() {
        val board = arrayOf(intArrayOf(1, 2, 3), intArrayOf(0, 4, 5))
        assertEquals(2, solution.slidingPuzzle(board))
    }
}
