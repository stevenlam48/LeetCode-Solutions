package suminamatrix

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SumInAMatrixTest {
    @Test
    fun exampleOne() {
        val nums = arrayOf(
            intArrayOf(7, 2, 1),
            intArrayOf(6, 4, 2),
            intArrayOf(6, 5, 3),
            intArrayOf(3, 2, 1)
        )
        assertEquals(15, Solution().matrixSum(nums))
    }

    @Test
    fun exampleTwo() {
        assertEquals(1, Solution().matrixSum(arrayOf(intArrayOf(1))))
    }

    @Test
    fun unsortedRowsWithTies() {
        val nums = arrayOf(intArrayOf(3, 1, 2), intArrayOf(2, 3, 1), intArrayOf(1, 2, 3))
        assertEquals(6, Solution().matrixSum(nums))
    }
}
