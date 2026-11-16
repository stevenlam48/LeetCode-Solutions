package countsubislands

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CountSubIslandsTest {
    private val solution = Solution()

    @Test
    fun example1() {
        val grid1 = arrayOf(
            intArrayOf(1, 1, 1, 0, 0),
            intArrayOf(0, 1, 1, 1, 1),
            intArrayOf(0, 0, 0, 0, 0),
            intArrayOf(1, 0, 0, 0, 0),
            intArrayOf(1, 1, 0, 1, 1)
        )
        val grid2 = arrayOf(
            intArrayOf(1, 1, 1, 0, 0),
            intArrayOf(0, 0, 1, 1, 1),
            intArrayOf(0, 1, 0, 0, 0),
            intArrayOf(1, 0, 1, 1, 0),
            intArrayOf(0, 1, 0, 1, 0)
        )
        assertEquals(3, solution.countSubIslands(grid1, grid2))
    }

    @Test
    fun example2() {
        val grid1 = arrayOf(
            intArrayOf(1, 0, 1, 0, 1),
            intArrayOf(1, 1, 1, 1, 1),
            intArrayOf(0, 0, 0, 0, 0),
            intArrayOf(1, 1, 1, 1, 1),
            intArrayOf(1, 0, 1, 0, 1)
        )
        val grid2 = arrayOf(
            intArrayOf(0, 0, 0, 0, 0),
            intArrayOf(1, 1, 1, 1, 1),
            intArrayOf(0, 1, 0, 1, 0),
            intArrayOf(0, 1, 0, 1, 0),
            intArrayOf(1, 0, 0, 0, 1)
        )
        assertEquals(2, solution.countSubIslands(grid1, grid2))
    }

    @Test
    fun singleLand() {
        assertEquals(1, solution.countSubIslands(arrayOf(intArrayOf(1)), arrayOf(intArrayOf(1))))
    }

    @Test
    fun singleWater() {
        assertEquals(0, solution.countSubIslands(arrayOf(intArrayOf(0)), arrayOf(intArrayOf(1))))
    }
}
