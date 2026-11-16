package minimumsumafterdivisiblesumdeletions

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MinimumSumAfterDivisibleSumDeletionsTest {
    @Test
    fun wholeArrayCanBeDeleted() {
        assertEquals(0L, Solution().minArraySum(intArrayOf(1, 2, 3), 3))
    }

    @Test
    fun suffixDeletionLeavesPrefix() {
        assertEquals(1L, Solution().minArraySum(intArrayOf(1, 2, 3), 5))
    }

    @Test
    fun separateDeletionsClearArray() {
        assertEquals(0L, Solution().minArraySum(intArrayOf(4, 6, 3, 2), 5))
    }

    @Test
    fun oneElementRemainsAfterDeletion() {
        assertEquals(1L, Solution().minArraySum(intArrayOf(1, 1, 1), 2))
    }

    @Test
    fun noDeletableSubarray() {
        assertEquals(6L, Solution().minArraySum(intArrayOf(1, 2, 3), 7))
    }
}
