package gridgame

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GridGameTest {
    @Test
    fun `standard examples`() {
        val solution = Solution()
        assertEquals(4L, solution.gridGame(arrayOf(intArrayOf(2, 5, 4), intArrayOf(1, 5, 1))))
        assertEquals(4L, solution.gridGame(arrayOf(intArrayOf(3, 3, 1), intArrayOf(8, 5, 2))))
        assertEquals(7L, solution.gridGame(arrayOf(intArrayOf(1, 3, 1, 15), intArrayOf(1, 3, 3, 1))))
    }

    @Test
    fun `single column`() {
        assertEquals(0L, Solution().gridGame(arrayOf(intArrayOf(10), intArrayOf(20))))
    }

    @Test
    fun `large sums use long arithmetic`() {
        val grid = arrayOf(intArrayOf(1_000_000_000, 1_000_000_000), intArrayOf(1_000_000_000, 1_000_000_000))
        assertEquals(1_000_000_000L, Solution().gridGame(grid))
    }
}
