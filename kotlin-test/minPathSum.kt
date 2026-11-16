package minPathSum

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinPathSumTest {
    @Test
    fun example1() {
        val grid = arrayOf(intArrayOf(1, 3, 1), intArrayOf(1, 5, 1), intArrayOf(4, 2, 1))
        assertEquals(7, Solution().minPathSum(grid))
    }

    @Test
    fun example2() {
        val grid = arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6))
        assertEquals(12, Solution().minPathSum(grid))
    }

    @Test
    fun singleCell() {
        assertEquals(1, Solution().minPathSum(arrayOf(intArrayOf(1))))
    }

    @Test
    fun prefersDownwardPath() {
        val grid = arrayOf(intArrayOf(1, 2), intArrayOf(1, 1))
        assertEquals(3, Solution().minPathSum(grid))
    }
}
