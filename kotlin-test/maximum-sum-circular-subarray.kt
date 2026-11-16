package maximumsumcircularsubarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumSumCircularSubarrayTest {
    private val solution = Solution()

    @Test
    fun nonCircularMaximum() {
        assertEquals(3, solution.maxSubarraySumCircular(intArrayOf(1, -2, 3, -2)))
    }

    @Test
    fun circularMaximumCrossesTheBoundary() {
        assertEquals(10, solution.maxSubarraySumCircular(intArrayOf(5, -3, 5)))
    }

    @Test
    fun secondCircularExample() {
        assertEquals(4, solution.maxSubarraySumCircular(intArrayOf(3, -1, 2, -1)))
    }

    @Test
    fun allNegativeValues() {
        assertEquals(-2, solution.maxSubarraySumCircular(intArrayOf(-3, -2, -3)))
    }

    @Test
    fun wholeArrayCanBeTheMaximum() {
        assertEquals(6, solution.maxSubarraySumCircular(intArrayOf(1, 2, 3)))
    }
}
