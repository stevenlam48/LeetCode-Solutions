package sparsematrixmultiplication

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SparseMatrixMultiplicationTest {
    @Test
    fun exampleOne() {
        val a = arrayOf(
            intArrayOf(1, 0, 0),
            intArrayOf(-1, 0, 3)
        )
        val b = arrayOf(
            intArrayOf(7, 0, 0),
            intArrayOf(0, 0, 0),
            intArrayOf(0, 0, 1)
        )
        val expected = arrayOf(
            intArrayOf(7, 0, 0),
            intArrayOf(-7, 0, 3)
        )
        assertTrue(expected.contentDeepEquals(Solution().multiply(a, b)))
    }

    @Test
    fun scalarOneByOne() {
        val result = Solution().multiply(arrayOf(intArrayOf(1)), arrayOf(intArrayOf(1)))
        assertTrue(arrayOf(intArrayOf(1)).contentDeepEquals(result))
    }

    @Test
    fun zeroRowTimesAnything() {
        val result = Solution().multiply(arrayOf(intArrayOf(0)), arrayOf(intArrayOf(5)))
        assertTrue(arrayOf(intArrayOf(0)).contentDeepEquals(result))
    }

    @Test
    fun rectangularMatrices() {
        val a = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(3, 4)
        )
        val b = arrayOf(
            intArrayOf(5, 6, 7),
            intArrayOf(8, 9, 10)
        )
        val expected = arrayOf(
            intArrayOf(21, 24, 27),
            intArrayOf(47, 54, 61)
        )
        assertTrue(expected.contentDeepEquals(Solution().multiply(a, b)))
    }
}
