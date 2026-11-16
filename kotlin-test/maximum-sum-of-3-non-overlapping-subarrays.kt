package maximumsumof3nonoverlappingsubarrays
// Time:  O(n)
// Space: O(n)

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MaximumSumOf3NonOverlappingSubarraysTest {
    @Test
    fun exampleOne() {
        val nums = intArrayOf(1, 2, 1, 2, 6, 7, 5, 1)
        assertArrayEquals(intArrayOf(0, 3, 5), Solution().maxSumOfThreeSubarrays(nums, 2))
    }

    @Test
    fun exampleTwoWithTiedWindowSums() {
        val nums = intArrayOf(1, 2, 1, 2, 1, 2, 1, 2, 1)
        assertArrayEquals(intArrayOf(0, 2, 7), Solution().maxSumOfThreeSubarrays(nums, 2))
    }

    @Test
    fun exactLengthInput() {
        val nums = intArrayOf(4, 5, 10, -2, 3, 6)
        assertArrayEquals(intArrayOf(0, 2, 4), Solution().maxSumOfThreeSubarrays(nums, 2))
    }

    @Test
    fun equalLengthOneSubarrays() {
        val nums = intArrayOf(2, 2, 2, 2, 2, 2)
        assertArrayEquals(intArrayOf(0, 1, 5), Solution().maxSumOfThreeSubarrays(nums, 1))
    }
}
