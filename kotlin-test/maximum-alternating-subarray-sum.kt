package maximumalternatingsubarraysum

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumAlternatingSubarraySumTest {
    private val solution = Solution()

    @Test
    fun exampleArray() {
        assertEquals(5L, solution.maximumAlternatingSubarraySum(intArrayOf(3, -1, 1, 2)))
    }

    @Test
    fun bestSubarrayStartsAtOddIndex() {
        assertEquals(4L, solution.maximumAlternatingSubarraySum(intArrayOf(2, 4, 1)))
    }

    @Test
    fun negativeNumbersAllowKadaneResetToZero() {
        assertEquals(0L, solution.maximumAlternatingSubarraySum(intArrayOf(-4, -2, -1)))
    }

    @Test
    fun singleElement() {
        assertEquals(-5L, solution.maximumAlternatingSubarraySum(intArrayOf(-5)))
    }

    @Test
    fun oddStartAlternatesAllRemainingElements() {
        assertEquals(101L, solution.maximumAlternatingSubarraySum(intArrayOf(8, 100, 4, 5)))
    }
}
