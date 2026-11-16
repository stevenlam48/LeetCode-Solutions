package minimumoperationstoremoveadjacentonesinmatrix

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumOperationsToRemoveAdjacentOnesInMatrixTest {
    @Test
    fun singleRow() {
        assertEquals(1, Solution().minimumOperations(arrayOf(intArrayOf(1, 1, 1))))
    }

    @Test
    fun fullTwoByTwo() {
        val grid = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(1, 1)
        )
        assertEquals(2, Solution().minimumOperations(grid))
    }

    @Test
    fun allZeros() {
        val grid = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(0, 0)
        )
        assertEquals(0, Solution().minimumOperations(grid))
    }

    @Test
    fun singleCell() {
        assertEquals(0, Solution().minimumOperations(arrayOf(intArrayOf(1))))
    }
}
