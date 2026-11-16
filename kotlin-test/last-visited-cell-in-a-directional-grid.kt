package lastvisitedcellinadirectionalgrid

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class LastVisitedCellInADirectionalGridTest {
    private val solution = Solution()

    @Test
    fun singleCellStopsAtBoundary() {
        val grid = arrayOf(charArrayOf('R'))
        assertArrayEquals(intArrayOf(0, 0), solution.lastVisitedCell(grid))
    }

    @Test
    fun twoCellCycleStopsBeforeRevisiting() {
        val grid = arrayOf(charArrayOf('R', 'L'))
        assertArrayEquals(intArrayOf(0, 1), solution.lastVisitedCell(grid))
    }

    @Test
    fun fourCellCycle() {
        val grid = arrayOf(
            charArrayOf('R', 'D'),
            charArrayOf('U', 'L')
        )
        assertArrayEquals(intArrayOf(1, 0), solution.lastVisitedCell(grid))
    }

    @Test
    fun pathEndingAtBoundary() {
        val grid = arrayOf(
            charArrayOf('R', 'R', 'D'),
            charArrayOf('U', 'L', 'R')
        )
        assertArrayEquals(intArrayOf(1, 2), solution.lastVisitedCell(grid))
    }
}
