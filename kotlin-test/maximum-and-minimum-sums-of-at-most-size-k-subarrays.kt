package maximumandminimumsumsofatmostsizeksubarrays

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumAndMinimumSumsOfAtMostSizeKSubarraysTest {
    private val solution = Solution()

    @Test
    fun increasingArrayWithPairs() {
        assertEquals(20L, solution.minMaxSubarraySum(intArrayOf(1, 2, 3), 2))
    }

    @Test
    fun includesAllLengthsUpToK() {
        assertEquals(24L, solution.minMaxSubarraySum(intArrayOf(1, 2, 3), 3))
    }

    @Test
    fun negativeNumbers() {
        assertEquals(-6L, solution.minMaxSubarraySum(intArrayOf(1, -3, 1), 2))
    }

    @Test
    fun duplicateNumbers() {
        assertEquals(12L, solution.minMaxSubarraySum(intArrayOf(2, 2), 2))
    }

    @Test
    fun sizeOneWindowsCountEachElementAsMinimumAndMaximum() {
        assertEquals(2L, solution.minMaxSubarraySum(intArrayOf(4, -5, 2), 1))
    }

    @Test
    fun emptyArray() {
        assertEquals(0L, solution.minMaxSubarraySum(intArrayOf(), 3))
    }
}
