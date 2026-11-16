package largestlocalvaluesinamatrix

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class LargestLocalValuesInAMatrixTest {
    @Test
    fun exampleGrid() {
        val grid = arrayOf(
            intArrayOf(9, 9, 8, 1), intArrayOf(5, 6, 2, 6),
            intArrayOf(8, 2, 6, 4), intArrayOf(6, 2, 2, 2)
        )
        val result = Solution().largestLocal(grid)
        assertArrayEquals(intArrayOf(9, 9), result[0])
        assertArrayEquals(intArrayOf(8, 6), result[1])
    }

    @Test
    fun singleWindow() {
        assertArrayEquals(intArrayOf(9), Solution().largestLocal(arrayOf(
            intArrayOf(1, 2, 3), intArrayOf(4, 9, 5), intArrayOf(6, 7, 8)
        ))[0])
    }

    @Test
    fun rectangularGrid() {
        val grid = arrayOf(intArrayOf(1, 2, 3, 4), intArrayOf(5, 6, 7, 8), intArrayOf(9, 10, 11, 12))
        assertArrayEquals(intArrayOf(11, 12), Solution().largestLocal(grid)[0])
    }
}
