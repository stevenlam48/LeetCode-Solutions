package maximumnumberofpointsfromgridqueries

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MaximumnumberofpointsfromgridqueriesTest {
    @Test
    fun example1() {
        val grid = arrayOf(intArrayOf(1, 2, 3), intArrayOf(2, 5, 7), intArrayOf(3, 5, 1))
        assertArrayEquals(intArrayOf(5, 8, 1), Solution().maxPoints(grid, intArrayOf(5, 6, 2)))
    }

    @Test
    fun example2() {
        val grid = arrayOf(intArrayOf(5, 2, 1), intArrayOf(1, 1, 2))
        assertArrayEquals(intArrayOf(0), Solution().maxPoints(grid, intArrayOf(3)))
    }

    @Test
    fun singleCellNotStrictlyLess() {
        val grid = arrayOf(intArrayOf(1))
        assertArrayEquals(intArrayOf(0), Solution().maxPoints(grid, intArrayOf(1)))
    }

    @Test
    fun singleCellStrictlyLess() {
        val grid = arrayOf(intArrayOf(1))
        assertArrayEquals(intArrayOf(1), Solution().maxPoints(grid, intArrayOf(2)))
    }
}
