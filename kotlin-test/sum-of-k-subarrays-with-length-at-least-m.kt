package sumofksubarrayswithlengthatleastm

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SumOfKSubarraysWithLengthAtLeastMTest {
    private val solution = Solution()

    @Test
    fun oneSubarrayCanUseAllElements() {
        assertEquals(10, solution.maxSum(intArrayOf(1, 2, 3, 4), 1, 2))
    }

    @Test
    fun separatedSubarrays() {
        assertEquals(12, solution.maxSum(intArrayOf(1, 2, -10, 4, 5), 2, 2))
    }

    @Test
    fun negativeElementsRequireShortestSubarray() {
        assertEquals(-5, solution.maxSum(intArrayOf(-5, -2, -3), 1, 2))
    }

    @Test
    fun minimumLengthsCoverInput() {
        assertEquals(21, solution.maxSum(intArrayOf(1, 2, 3, 4, 5, 6), 2, 2))
    }

    @Test
    fun singleElement() {
        assertEquals(7, solution.maxSum(intArrayOf(7), 1, 1))
    }
}
