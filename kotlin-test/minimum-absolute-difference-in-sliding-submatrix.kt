package minimumabsolutedifferenceinslidingsubmatrix

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumAbsoluteDifferenceInSlidingSubmatrixTest {
    private fun assertMatrix(expected: Array<IntArray>, actual: Array<IntArray>) {
        assertEquals(expected.size, actual.size)
        for (i in expected.indices) {
            assertArrayEquals(expected[i], actual[i])
        }
    }

    @Test
    fun example1() {
        val grid = arrayOf(intArrayOf(1, 8), intArrayOf(3, 6))
        assertMatrix(arrayOf(intArrayOf(2)), Solution().minAbsDiff(grid, 2))
    }

    @Test
    fun example2() {
        val grid = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
        )
        val expected = arrayOf(intArrayOf(1, 1), intArrayOf(1, 1))
        assertMatrix(expected, Solution().minAbsDiff(grid, 2))
    }

    @Test
    fun allEqual() {
        val grid = arrayOf(intArrayOf(1, 1), intArrayOf(1, 1))
        assertMatrix(arrayOf(intArrayOf(0)), Solution().minAbsDiff(grid, 2))
    }

    @Test
    fun kEqualsOne() {
        val grid = arrayOf(intArrayOf(5, 3), intArrayOf(2, 9))
        val expected = arrayOf(intArrayOf(0, 0), intArrayOf(0, 0))
        assertMatrix(expected, Solution().minAbsDiff(grid, 1))
    }

    @Test
    fun duplicatesInWindow() {
        val grid = arrayOf(
            intArrayOf(3, 3, 3),
            intArrayOf(3, 3, 3),
            intArrayOf(3, 3, 3)
        )
        val expected = arrayOf(intArrayOf(0, 0), intArrayOf(0, 0))
        assertMatrix(expected, Solution().minAbsDiff(grid, 2))
    }
}
