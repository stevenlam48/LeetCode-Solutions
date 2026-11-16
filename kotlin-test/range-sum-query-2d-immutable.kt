package rangesumquery2dimmutable
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class RangeSumQuery2dImmutableTest {
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
        assertEquals(11, numMatrix.sumRegion(1, 1, 2, 2))
        assertEquals(12, numMatrix.sumRegion(1, 2, 2, 4))
    }

    @Test
    fun singleCellsAndWholeMatrix() {
        val numMatrix = NumMatrix(arrayOf(
            intArrayOf(-1, 2, 3),
            intArrayOf(4, -5, 6)
        ))
        assertEquals(-5, numMatrix.sumRegion(1, 1, 1, 1))
        assertEquals(9, numMatrix.sumRegion(0, 0, 1, 2))
        assertEquals(9, numMatrix.sumRegion(0, 2, 1, 2))
    }

    @Test
    fun emptyMatrix() {
        assertDoesNotThrow { NumMatrix(emptyArray()) }
    }
}
