package findsortedsubmatriceswithmaximumelementatmostk

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindSortedSubmatricesWithMaximumElementAtMostKTest {
    @Test
    fun testUniformGrid() {
        val grid = arrayOf(intArrayOf(1, 1), intArrayOf(1, 1))
        assertEquals(9L, Solution().countSubmatrices(grid, 1))
    }

    @Test
    fun testIncreasingRows() {
        val grid = arrayOf(intArrayOf(1, 2), intArrayOf(1, 2))
        assertEquals(6L, Solution().countSubmatrices(grid, 2))
    }

    @Test
    fun testDecreasingGrid() {
        val grid = arrayOf(intArrayOf(3, 2, 1), intArrayOf(3, 2, 1))
        assertEquals(18L, Solution().countSubmatrices(grid, 3))
    }

    @Test
    fun testSingleCellTooLarge() {
        val grid = arrayOf(intArrayOf(5))
        assertEquals(0L, Solution().countSubmatrices(grid, 4))
        assertEquals(1L, Solution().countSubmatrices(grid, 5))
    }

    @Test
    fun testSecondDecreasingGrid() {
        val grid = arrayOf(intArrayOf(2, 1), intArrayOf(2, 1))
        assertEquals(9L, Solution().countSubmatrices(grid, 2))
    }
}
