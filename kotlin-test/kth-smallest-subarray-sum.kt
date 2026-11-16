package kthsmallestsubarraysum

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KthSmallestSubarraySumTest {
    @Test
    fun exampleArray() {
        assertEquals(3, Solution().kthSmallestSubarraySum(intArrayOf(2, 1, 3), 4))
    }

    @Test
    fun duplicateSums() {
        assertEquals(1, Solution().kthSmallestSubarraySum(intArrayOf(1, 1, 1), 3))
        assertEquals(2, Solution().kthSmallestSubarraySum(intArrayOf(1, 1, 1), 4))
    }

    @Test
    fun singleElement() {
        assertEquals(7, Solution().kthSmallestSubarraySum(intArrayOf(7), 1))
    }

    @Test
    fun allSubarrays() {
        assertEquals(6, Solution().kthSmallestSubarraySum(intArrayOf(2, 1, 3), 6))
    }
}
