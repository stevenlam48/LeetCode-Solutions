package maximumsumobtainedofanypermutation
// Time:  O(nlogn)
// Space: O(n)

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumSumObtainedOfAnyPermutationTest {
    @Test
    fun overlappingRequests() {
        val nums = intArrayOf(1, 2, 3, 4, 5)
        val requests = arrayOf(
            intArrayOf(0, 2),
            intArrayOf(1, 3),
            intArrayOf(1, 1)
        )
        assertEquals(28, Solution().maxSumRangeQuery(nums, requests))
    }

    @Test
    fun singleFullRangeRequest() {
        val nums = intArrayOf(4, 1, 3, 2)
        val requests = arrayOf(intArrayOf(0, 3))
        assertEquals(10, Solution().maxSumRangeQuery(nums, requests))
    }

    @Test
    fun noRequests() {
        val nums = intArrayOf(4, 1, 3)
        assertEquals(0, Solution().maxSumRangeQuery(nums, emptyArray()))
    }

    @Test
    fun disjointRequests() {
        val nums = intArrayOf(1, 2, 3, 4, 5, 10)
        val requests = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(4, 5)
        )
        assertEquals(19, Solution().maxSumRangeQuery(nums, requests))
    }
}
