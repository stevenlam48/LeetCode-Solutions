package nearestexitfromentranceinmaze

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NearestExitFromEntranceInMazeTest {
    @Test
    fun `finds nearest exit`() {
        val maze = arrayOf(
            charArrayOf('+', '+', '.', '+'),
            charArrayOf('.', '.', '.', '+'),
            charArrayOf('+', '+', '+', '.')
        )
        assertEquals(1, Solution().nearestExit(maze, intArrayOf(1, 2)))
    }

    @Test
    fun `finds two step exit`() {
        val maze = arrayOf(
            charArrayOf('+', '+', '+'),
            charArrayOf('.', '.', '.'),
            charArrayOf('+', '+', '+')
        )
        assertEquals(2, Solution().nearestExit(maze, intArrayOf(1, 0)))
    }

    @Test
    fun `returns minus one when no exit is reachable`() {
        val maze = arrayOf(
            charArrayOf('+', '+', '+'),
            charArrayOf('+', '.', '+'),
            charArrayOf('+', '+', '+')
        )
        assertEquals(-1, Solution().nearestExit(maze, intArrayOf(1, 1)))
    }

    @Test
    fun `does not count entrance itself as exit`() {
        val maze = arrayOf(charArrayOf('.', '+', '.'))
        assertEquals(-1, Solution().nearestExit(maze, intArrayOf(0, 0)))
    }
}
