package maximumsumscoreofarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumSumScoreOfArrayTest {
    private val solution = Solution()

    @Test
    fun standardExample() {
        assertEquals(9L, solution.maximumSumScore(intArrayOf(4, 3, 2)))
    }

    @Test
    fun singleElement() {
        assertEquals(1L, solution.maximumSumScore(intArrayOf(1)))
    }

    @Test
    fun allNegativeValues() {
        assertEquals(-1L, solution.maximumSumScore(intArrayOf(-1, -2, -3)))
    }

    @Test
    fun zeros() {
        assertEquals(0L, solution.maximumSumScore(intArrayOf(0, 0)))
    }

    @Test
    fun increasingValues() {
        assertEquals(15L, solution.maximumSumScore(intArrayOf(1, 2, 3, 4, 5)))
    }
}
