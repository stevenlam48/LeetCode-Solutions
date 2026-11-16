package minimumoperationstomakecolumnsstrictlyincreasing

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumOperationsToMakeColumnsStrictlyIncreasingTest {
    @Test
    fun exampleGrid() {
        val grid = arrayOf(
            intArrayOf(3, 2),
            intArrayOf(1, 1)
        )
        assertEquals(5, Solution().minimumOperations(grid))
    }

    @Test
    fun equalColumns() {
        val grid = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(1, 1)
        )
        assertEquals(2, Solution().minimumOperations(grid))
    }

    @Test
    fun singleRowNeedsNothing() {
        val grid = arrayOf(intArrayOf(1, 2, 3))
        assertEquals(0, Solution().minimumOperations(grid))
    }

    @Test
    fun alreadyStrict() {
        val grid = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(3, 4)
        )
        assertEquals(0, Solution().minimumOperations(grid))
    }
}
