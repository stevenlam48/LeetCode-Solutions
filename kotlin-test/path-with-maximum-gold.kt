package pathwithmaximumgold

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PathWithMaximumGoldTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        val grid = arrayOf(
            intArrayOf(0, 6, 0),
            intArrayOf(5, 8, 7),
            intArrayOf(0, 9, 0)
        )
        assertEquals(24, solution.getMaximumGold(grid))
    }

    @Test
    fun testExample2() {
        val grid = arrayOf(
            intArrayOf(1, 0, 7),
            intArrayOf(2, 0, 6),
            intArrayOf(3, 4, 5),
            intArrayOf(0, 3, 0),
            intArrayOf(9, 0, 20)
        )
        assertEquals(28, solution.getMaximumGold(grid))
    }

    @Test
    fun testNoGold() {
        val grid = arrayOf(intArrayOf(0, 0, 0))
        assertEquals(0, solution.getMaximumGold(grid))
    }

    @Test
    fun testSingleCell() {
        val grid = arrayOf(intArrayOf(1))
        assertEquals(1, solution.getMaximumGold(grid))
    }
}
