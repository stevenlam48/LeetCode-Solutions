package maximummultiplicationscore

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumMultiplicationScoreTest {
    private val solution = Solution()

    @Test
    fun example() {
        assertEquals(32L, solution.maxScore(intArrayOf(3, 2, 5, 6), intArrayOf(2, -6, 4, -5, 3)))
    }

    @Test
    fun allOnes() {
        assertEquals(4L, solution.maxScore(intArrayOf(1, 1, 1, 1), intArrayOf(1, 1, 1, 1)))
    }

    @Test
    fun negativeA() {
        assertEquals(-30L, solution.maxScore(intArrayOf(-1, -2, -3, -4), intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun chooseBestSubset() {
        assertEquals(-14L, solution.maxScore(intArrayOf(1, 2, 3), intArrayOf(-1, -2, -3, -4)))
    }

    @Test
    fun singleElement() {
        assertEquals(20L, solution.maxScore(intArrayOf(5), intArrayOf(-3, 0, 4)))
    }
}
