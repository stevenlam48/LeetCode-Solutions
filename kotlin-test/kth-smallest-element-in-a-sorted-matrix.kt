package kthsmallestelementinasortedmatrix

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KthSmallestElementInASortedMatrixTest {
    @Test
    fun exampleMatrix() {
        val matrix = arrayOf(intArrayOf(1, 5, 9), intArrayOf(10, 11, 13), intArrayOf(12, 13, 15))
        assertEquals(13, Solution().kthSmallest(matrix, 8))
    }

    @Test
    fun singleElement() {
        assertEquals(-5, Solution().kthSmallest(arrayOf(intArrayOf(-5)), 1))
    }

    @Test
    fun rectangularMatrixWithDuplicates() {
        val matrix = arrayOf(intArrayOf(1, 2, 2), intArrayOf(3, 3, 4))
        assertEquals(2, Solution().kthSmallest(matrix, 3))
        assertEquals(3, Solution().kthSmallest(matrix, 5))
    }

    @Test
    fun transposedTraversalMatrix() {
        val matrix = arrayOf(intArrayOf(1, 6), intArrayOf(2, 7), intArrayOf(3, 8))
        assertEquals(6, Solution().kthSmallest(matrix, 4))
    }
}
