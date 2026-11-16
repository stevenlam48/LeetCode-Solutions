package medianofarowwisesortedmatrix

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MedianOfARowWiseSortedMatrixTest {
    @Test
    fun exampleMatrix() {
        val grid = arrayOf(intArrayOf(1, 3, 5), intArrayOf(2, 6, 9), intArrayOf(3, 6, 9))
        assertEquals(5, Solution().matrixMedian(grid))
    }

    @Test
    fun singleElement() {
        assertEquals(1, Solution().matrixMedian(arrayOf(intArrayOf(1))))
    }

    @Test
    fun negativeAndDuplicateValues() {
        val grid = arrayOf(intArrayOf(-5, -3, -1), intArrayOf(-4, -2, 0), intArrayOf(-3, 2, 4))
        assertEquals(-2, Solution().matrixMedian(grid))
    }
}
