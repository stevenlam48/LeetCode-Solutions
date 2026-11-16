package largestlocalvaluesinamatrixii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LargestLocalValuesInAMatrixIiTest {
    @Test
    fun distinctValuesInSmallMatrix() {
        assertEquals(1, Solution().countLocalMaximums(arrayOf(intArrayOf(1, 2), intArrayOf(3, 4))))
    }

    @Test
    fun diagonalLocalMaximums() {
        val matrix = arrayOf(intArrayOf(1, 0, 0), intArrayOf(0, 0, 0), intArrayOf(0, 0, 1))
        assertEquals(2, Solution().countLocalMaximums(matrix))
    }

    @Test
    fun zerosAreIgnored() {
        assertEquals(0, Solution().countLocalMaximums(arrayOf(intArrayOf(0))))
        assertEquals(0, Solution().countLocalMaximums(arrayOf(intArrayOf(0, 0), intArrayOf(0, 0))))
    }

    @Test
    fun allEqualLargeValues() {
        assertEquals(4, Solution().countLocalMaximums(arrayOf(intArrayOf(2, 2), intArrayOf(2, 2))))
    }

    @Test
    fun singleNonzeroValue() {
        assertEquals(1, Solution().countLocalMaximums(arrayOf(intArrayOf(7))))
    }
}
