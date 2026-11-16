package countsubmatriceswithtopleftelementandsumlessthank

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CountSubmatricesWithTopLeftElementAndSumLessThanKTest {
    private val solution = Solution()

    @Test
    fun `counts standard example`() {
        val grid = arrayOf(intArrayOf(7, 6, 3), intArrayOf(6, 6, 1))
        assertEquals(4, solution.countSubmatrices(grid, 18))
    }

    @Test
    fun `includes sums equal to k`() {
        assertEquals(1, solution.countSubmatrices(arrayOf(intArrayOf(5)), 5))
        assertEquals(0, solution.countSubmatrices(arrayOf(intArrayOf(5)), 4))
    }

    @Test
    fun `counts prefixes independently`() {
        val grid = arrayOf(intArrayOf(1, 2), intArrayOf(3, 4))
        assertEquals(4, solution.countSubmatrices(grid, 10))
    }

    @Test
    fun `excludes prefixes above k`() {
        val grid = arrayOf(intArrayOf(1, 2), intArrayOf(3, 4))
        assertEquals(2, solution.countSubmatrices(grid, 3))
    }

    @Test
    fun `supports negative values`() {
        val grid = arrayOf(intArrayOf(2, -1), intArrayOf(0, 3))
        assertEquals(1, solution.countSubmatrices(grid, 1))
    }
}
