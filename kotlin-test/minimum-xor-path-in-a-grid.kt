package minimumxorpathinagrid

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MinimumXorPathInAGridTest {
    private val solution = Solution()

    @Test
    fun testTwoByTwo() {
        val grid = arrayOf(intArrayOf(1, 2), intArrayOf(3, 4))
        assertEquals(6, solution.minCost(grid))
    }

    @Test
    fun testSingleCell() {
        val grid = arrayOf(intArrayOf(1))
        assertEquals(1, solution.minCost(grid))
    }

    @Test
    fun testSingleRow() {
        val grid = arrayOf(intArrayOf(1, 2))
        assertEquals(3, solution.minCost(grid))
    }

    @Test
    fun testZeroXor() {
        val grid = arrayOf(intArrayOf(5, 3), intArrayOf(4, 6))
        assertEquals(0, solution.minCost(grid))
    }

    @Test
    fun testSingleColumn() {
        val grid = arrayOf(intArrayOf(1), intArrayOf(2), intArrayOf(4))
        assertEquals(7, solution.minCost(grid))
    }
}
