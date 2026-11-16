package findvalidmatrixgivenrowandcolumnsums

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class FindValidMatrixGivenRowAndColumnSumsTest {
    private fun assertMatrix(expected: Array<IntArray>, actual: Array<IntArray>) {
        org.junit.jupiter.api.Assertions.assertEquals(expected.size, actual.size)
        for (i in expected.indices) {
            assertArrayEquals(expected[i], actual[i])
        }
    }

    @Test
    fun exampleOne() {
        assertMatrix(
            arrayOf(intArrayOf(3, 0), intArrayOf(1, 7)),
            Solution().restoreMatrix(intArrayOf(3, 8), intArrayOf(4, 7))
        )
    }

    @Test
    fun exampleTwo() {
        assertMatrix(
            arrayOf(intArrayOf(5, 0, 0), intArrayOf(3, 4, 0), intArrayOf(0, 2, 8)),
            Solution().restoreMatrix(intArrayOf(5, 7, 10), intArrayOf(8, 6, 8))
        )
    }

    @Test
    fun singleCell() {
        assertMatrix(arrayOf(intArrayOf(4)), Solution().restoreMatrix(intArrayOf(4), intArrayOf(4)))
    }

    @Test
    fun zeroEntries() {
        assertMatrix(
            arrayOf(intArrayOf(0, 0), intArrayOf(0, 3)),
            Solution().restoreMatrix(intArrayOf(0, 3), intArrayOf(0, 3))
        )
    }
}
