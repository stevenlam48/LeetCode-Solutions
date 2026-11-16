package minimumoperationstowritetheletteryonagrid

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumOperationsToWriteTheLetterYOnAGridTest {
    private val solution = Solution()

    @Test
    fun handlesUniformGrid() {
        val grid = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(0, 0, 0),
            intArrayOf(0, 0, 0)
        )
        assertEquals(4, solution.minimumOperationsToWriteY(grid))
    }

    @Test
    fun handlesLeetCodeExample() {
        val grid = arrayOf(
            intArrayOf(1, 2, 2),
            intArrayOf(1, 1, 0),
            intArrayOf(0, 1, 0)
        )
        assertEquals(3, solution.minimumOperationsToWriteY(grid))
    }

    @Test
    fun separatesYAndNonYCells() {
        val grid = arrayOf(
            intArrayOf(1, 0, 0),
            intArrayOf(0, 1, 0),
            intArrayOf(0, 0, 1)
        )
        assertEquals(3, solution.minimumOperationsToWriteY(grid))
    }

    @Test
    fun handlesFiveByFiveGrid() {
        val grid = arrayOf(
            intArrayOf(0, 1, 1, 1, 2),
            intArrayOf(1, 0, 1, 2, 1),
            intArrayOf(1, 1, 0, 1, 1),
            intArrayOf(1, 1, 0, 1, 1),
            intArrayOf(1, 1, 2, 1, 1)
        )
        assertEquals(3, solution.minimumOperationsToWriteY(grid))
    }

    @Test
    fun handlesSingleCellGrid() {
        assertEquals(0, solution.minimumOperationsToWriteY(arrayOf(intArrayOf(1))))
    }
}
