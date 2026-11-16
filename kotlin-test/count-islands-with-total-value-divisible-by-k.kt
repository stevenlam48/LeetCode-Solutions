package countislandswithtotalvaluedivisiblebyk

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountIslandsWithTotalValueDivisibleByKTest {
    private val solution = Solution()

    @Test
    fun countsFirstExample() {
        val grid = arrayOf(
            intArrayOf(0, 2, 1, 0, 0),
            intArrayOf(0, 5, 0, 0, 5),
            intArrayOf(0, 0, 1, 0, 0),
            intArrayOf(0, 1, 4, 7, 0),
            intArrayOf(0, 2, 0, 0, 8)
        )
        assertEquals(2, solution.countIslands(grid, 5))
    }

    @Test
    fun countsDisconnectedSingleCellIslands() {
        val grid = arrayOf(
            intArrayOf(3, 0, 3, 0),
            intArrayOf(0, 3, 0, 3),
            intArrayOf(3, 0, 3, 0)
        )
        assertEquals(6, solution.countIslands(grid, 3))
    }

    @Test
    fun rejectsIslandWithNondivisibleSum() {
        assertEquals(0, solution.countIslands(arrayOf(intArrayOf(1, 1), intArrayOf(2, 2)), 5))
    }
}
