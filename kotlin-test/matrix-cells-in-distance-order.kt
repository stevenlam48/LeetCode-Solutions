package matrixcellsindistanceorder

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MatrixCellsInDistanceOrderTest {
    private val solution = Solution()

    @Test
    fun ordersCellsFromCenterOfExampleGrid() {
        val actual = solution.allCellsDistOrder(2, 2, 0, 1)
        val expected = arrayOf(intArrayOf(0, 1), intArrayOf(0, 0), intArrayOf(1, 1), intArrayOf(1, 0))
        assertArrayEquals(expected, actual)
    }

    @Test
    fun ordersCellsFromInteriorOfExampleGrid() {
        val actual = solution.allCellsDistOrder(2, 3, 1, 2)
        val expected = arrayOf(
            intArrayOf(1, 2), intArrayOf(0, 2), intArrayOf(1, 1),
            intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(0, 0)
        )
        assertArrayEquals(expected, actual)
    }

    @Test
    fun returnsSingleCellGrid() {
        assertArrayEquals(arrayOf(intArrayOf(0, 0)), solution.allCellsDistOrder(1, 1, 0, 0))
    }

    @Test
    fun visitsEveryCellExactlyOnceInRectangularGrid() {
        val actual = solution.allCellsDistOrder(3, 2, 2, 0)
        assertEquals(6, actual.size)
        assertEquals(6, actual.map { it.toList() }.toSet().size)
    }
}
