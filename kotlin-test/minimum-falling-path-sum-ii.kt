package minimumfallingpathsumii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumFallingPathSumIiTest {
    @Test
    fun example1() {
        val matrix = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
        )
        assertEquals(13, Solution().minFallingPathSum(matrix))
    }

    @Test
    fun singleElement() {
        assertEquals(7, Solution().minFallingPathSum(arrayOf(intArrayOf(7))))
    }

    @Test
    fun singleRowReturnsMinimum() {
        assertEquals(1, Solution().minFallingPathSum(arrayOf(intArrayOf(3, 1, 2))))
    }

    @Test
    fun negativeValues() {
        val matrix = arrayOf(
            intArrayOf(-1, -2, -3),
            intArrayOf(-4, -5, -6)
        )
        assertEquals(-8, Solution().minFallingPathSum(matrix))
    }
}
