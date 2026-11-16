package rangesumquery2dmutable
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class RangeSumQuery2dMutableTest {
    @Test
    fun leetCodeExample() {
        val numMatrix = NumMatrix(arrayOf(
            intArrayOf(3, 0, 1, 4, 2),
            intArrayOf(5, 6, 3, 2, 1),
            intArrayOf(1, 2, 0, 1, 5),
            intArrayOf(4, 1, 0, 1, 7),
            intArrayOf(1, 0, 3, 0, 5)
        ))
        assertEquals(8, numMatrix.sumRegion(2, 1, 4, 3))
        numMatrix.update(3, 2, 2)
        assertEquals(10, numMatrix.sumRegion(2, 1, 4, 3))
    }

    @Test
    fun updatesNegativesAndSingleCells() {
        val matrix = arrayOf(intArrayOf(-2, 4), intArrayOf(3, -1))
        val numMatrix = NumMatrix(matrix)
        assertEquals(4, numMatrix.sumRegion(0, 0, 1, 1))
        numMatrix.update(0, 0, 5)
        numMatrix.update(1, 1, -7)
        assertEquals(5, numMatrix.sumRegion(0, 0, 1, 1))
        assertEquals(-7, numMatrix.sumRegion(1, 1, 1, 1))
        assertEquals(5, matrix[0][0])
        numMatrix.update(0, 0, 5)
        assertEquals(5, numMatrix.sumRegion(0, 0, 0, 0))
    }

    @Test
    fun singleElementAndEmptyMatrix() {
        val numMatrix = NumMatrix(arrayOf(intArrayOf(7)))
        assertEquals(7, numMatrix.sumRegion(0, 0, 0, 0))
        numMatrix.update(0, 0, -3)
        assertEquals(-3, numMatrix.sumRegion(0, 0, 0, 0))
        assertDoesNotThrow { NumMatrix(emptyArray()) }
    }
}
