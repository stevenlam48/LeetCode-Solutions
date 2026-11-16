package cellswithoddvaluesinamatrix

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CellsWithOddValuesInAMatrixTest {
    private val solution = Solution()

    @Test
    fun exampleOne() {
        assertEquals(
            6,
            solution.oddCells(2, 3, arrayOf(intArrayOf(0, 1), intArrayOf(1, 1)))
        )
    }

    @Test
    fun exampleTwo() {
        assertEquals(
            0,
            solution.oddCells(2, 2, arrayOf(intArrayOf(1, 1), intArrayOf(0, 0)))
        )
    }

    @Test
    fun noIndices() {
        assertEquals(0, solution.oddCells(3, 4, emptyArray()))
    }

    @Test
    fun repeatedIndicesCancel() {
        assertEquals(
            0,
            solution.oddCells(2, 2, arrayOf(intArrayOf(0, 1), intArrayOf(0, 1)))
        )
    }
}
