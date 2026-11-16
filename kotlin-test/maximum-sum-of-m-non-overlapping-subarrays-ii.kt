package maximumsumofmnonoverlappingsubarraysii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumSumOfMNonOverlappingSubarraysIITest {
    private val solution = Solution()

    @Test
    fun twoSubarraysOfLengthTwo() {
        assertEquals(10L, solution.maximumSum(intArrayOf(1, 2, 3, 4), 2, 2, 3))
    }

    @Test
    fun singleSubarrayWithNegatives() {
        assertEquals(5L, solution.maximumSum(intArrayOf(-1, 2, 3, -4), 1, 1, 2))
    }

    @Test
    fun twoAdjacentSubarrays() {
        assertEquals(14L, solution.maximumSum(intArrayOf(1, 2, 3, 4, 5), 2, 1, 2))
    }

    @Test
    fun singleElementSubarray() {
        assertEquals(5L, solution.maximumSum(intArrayOf(5, 1, 2), 1, 1, 1))
    }

    @Test
    fun allNegativeValues() {
        assertEquals(-1L, solution.maximumSum(intArrayOf(-1, -2, -3), 1, 1, 1))
    }
}
