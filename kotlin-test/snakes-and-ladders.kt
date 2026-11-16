package snakesandladders

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SnakesAndLaddersTest {
    @Test
    fun example1() {
        val board = arrayOf(
            intArrayOf(-1, -1, -1, -1, -1, -1),
            intArrayOf(-1, -1, -1, -1, -1, -1),
            intArrayOf(-1, -1, -1, -1, -1, -1),
            intArrayOf(-1, 35, -1, -1, 13, -1),
            intArrayOf(-1, -1, -1, -1, -1, -1),
            intArrayOf(-1, 15, -1, -1, -1, -1)
        )
        assertEquals(4, Solution().snakesAndLadders(board))
    }

    @Test
    fun example2() {
        val board = arrayOf(intArrayOf(-1, -1), intArrayOf(-1, 3))
        assertEquals(1, Solution().snakesAndLadders(board))
    }

    @Test
    fun unreachableTarget() {
        val board = arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(1, 1, 1),
            intArrayOf(1, 1, 1)
        )
        assertEquals(-1, Solution().snakesAndLadders(board))
    }

    @Test
    fun singleCell() {
        val board = arrayOf(intArrayOf(-1))
        assertEquals(0, Solution().snakesAndLadders(board))
    }
}
