package longestincreasingpathinamatrix

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestIncreasingPathInAMatrixTest {
    private val solution = Solution()

    @Test
    fun standardExample() {
        assertEquals(
            4,
            solution.longestIncreasingPath(
                arrayOf(intArrayOf(9, 9, 4), intArrayOf(6, 6, 8), intArrayOf(2, 1, 1))
            )
        )
    }

    @Test
    fun secondExample() {
        assertEquals(
            4,
            solution.longestIncreasingPath(
                arrayOf(intArrayOf(3, 4, 5), intArrayOf(3, 2, 6), intArrayOf(2, 2, 1))
            )
        )
    }

    @Test
    fun singleCell() {
        assertEquals(1, solution.longestIncreasingPath(arrayOf(intArrayOf(1))))
    }

    @Test
    fun equalValues() {
        assertEquals(1, solution.longestIncreasingPath(arrayOf(intArrayOf(7, 7), intArrayOf(7, 7))))
    }

    @Test
    fun emptyMatrix() {
        assertEquals(0, solution.longestIncreasingPath(arrayOf()))
    }
}
