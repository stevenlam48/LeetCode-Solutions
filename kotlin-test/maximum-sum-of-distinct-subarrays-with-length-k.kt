package maximumsumofdistinctsubarrayswithlengthk

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumSumOfDistinctSubarraysWithLengthKTest {
    private val solution = Solution()

    @Test
    fun standardExample() {
        assertEquals(15L, solution.maximumSubarraySum(intArrayOf(1, 5, 4, 2, 9, 9, 9), 3))
    }

    @Test
    fun allDuplicatesGiveZero() {
        assertEquals(0L, solution.maximumSubarraySum(intArrayOf(4, 4, 4), 3))
    }

    @Test
    fun slidingWindowOfTwo() {
        assertEquals(7L, solution.maximumSubarraySum(intArrayOf(1, 2, 3, 4), 2))
    }

    @Test
    fun duplicateForcesWindowToShrink() {
        assertEquals(24L, solution.maximumSubarraySum(intArrayOf(1, 1, 1, 7, 8, 9), 3))
    }

    @Test
    fun windowOfOne() {
        assertEquals(9L, solution.maximumSubarraySum(intArrayOf(5, 2, 9), 1))
    }
}
