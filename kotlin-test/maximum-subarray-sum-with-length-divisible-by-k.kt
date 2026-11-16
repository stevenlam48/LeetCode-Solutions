package maximumsubarraysumwithlengthdivisiblebyk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumSubarraySumWithLengthDivisibleByKTest {
    private val solution = Solution()

    @Test
    fun positiveValues() {
        assertEquals(3L, solution.maxSubarraySum(intArrayOf(1, 2), 1))
    }

    @Test
    fun mixedValues() {
        assertEquals(4L, solution.maxSubarraySum(intArrayOf(-5, 1, 2, -3, 4), 2))
    }

    @Test
    fun negativeValues() {
        assertEquals(-3L, solution.maxSubarraySum(intArrayOf(-1, -2, -3, -4, -5), 2))
    }

    @Test
    fun lengthGreaterThanK() {
        assertEquals(10L, solution.maxSubarraySum(intArrayOf(1, 2, 3, 4), 2))
    }

    @Test
    fun singleElement() {
        assertEquals(7L, solution.maxSubarraySum(intArrayOf(7), 1))
    }
}
