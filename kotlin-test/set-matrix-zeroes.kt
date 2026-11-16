package setmatrixzeroes

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SetMatrixZeroesTest {
    @Test
    fun zeroesInteriorRowAndColumn() {
        val matrix = arrayOf(intArrayOf(1, 1, 1), intArrayOf(1, 0, 1), intArrayOf(1, 1, 1))
        Solution().setZeroes(matrix)
        assertArrayEquals(
            arrayOf(intArrayOf(1, 0, 1), intArrayOf(0, 0, 0), intArrayOf(1, 0, 1)),
            matrix
        )
    }

    @Test
    fun handlesMultipleZeroesUsingFirstMarkers() {
        val matrix = arrayOf(
            intArrayOf(0, 1, 2, 0),
            intArrayOf(3, 4, 5, 2),
            intArrayOf(1, 3, 1, 5)
        )
        Solution().setZeroes(matrix)
        assertArrayEquals(
            arrayOf(
                intArrayOf(0, 0, 0, 0),
                intArrayOf(0, 4, 5, 0),
                intArrayOf(0, 3, 1, 0)
            ),
            matrix
        )
    }

    @Test
    fun preservesMatrixWithoutZeroes() {
        val matrix = arrayOf(intArrayOf(1, 2), intArrayOf(3, 4))
        Solution().setZeroes(matrix)
        assertArrayEquals(arrayOf(intArrayOf(1, 2), intArrayOf(3, 4)), matrix)
    }

    @Test
    fun handlesEmptyMatrix() {
        val matrix = emptyArray<IntArray>()
        Solution().setZeroes(matrix)
        assertEquals(0, matrix.size)
    }
}
