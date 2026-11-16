package minimumfallingpathsum

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumFallingPathSumTest {
    @Test
    fun example1() {
        val matrix = arrayOf(
            intArrayOf(2, 1, 3),
            intArrayOf(6, 5, 4),
            intArrayOf(7, 8, 9)
        )
        assertEquals(13, Solution().minFallingPathSum(matrix))
    }

    @Test
    fun example2() {
        val matrix = arrayOf(
            intArrayOf(-19, 57),
            intArrayOf(-40, -5)
        )
        assertEquals(-59, Solution().minFallingPathSum(matrix))
    }

    @Test
    fun singleElement() {
        assertEquals(7, Solution().minFallingPathSum(arrayOf(intArrayOf(7))))
    }

    @Test
    fun negativeValues() {
        val matrix = arrayOf(
            intArrayOf(1, -2, 3),
            intArrayOf(-4, 5, -6),
            intArrayOf(7, -8, 9)
        )
        assertEquals(-16, Solution().minFallingPathSum(matrix))
    }
}
