package maximumuniquesubarraysumafterdeletion

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumUniqueSubarraySumAfterDeletionTest {
    @Test
    fun examples() {
        assertEquals(15, Solution().maxSum(intArrayOf(1, 2, 3, 4, 5)))
        assertEquals(5, Solution().maxSum(intArrayOf(4, 0, 1)))
    }

    @Test
    fun duplicatePositiveValues() {
        assertEquals(6, Solution().maxSum(intArrayOf(1, 2, 2, 3, 3)))
    }

    @Test
    fun nonPositiveValues() {
        assertEquals(-1, Solution().maxSum(intArrayOf(-1, -2, -3)))
        assertEquals(0, Solution().maxSum(intArrayOf(0, 0, -2)))
    }
}
