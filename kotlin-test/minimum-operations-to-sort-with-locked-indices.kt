package minimumoperationstosortwithlockedindices

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumOperationsToSortWithLockedIndicesTest {
    @Test
    fun sortedArrayNeedsNoOperations() {
        assertEquals(0, Solution().minOperations(intArrayOf(1, 2, 3), intArrayOf(0, 0, 0), 0))
    }

    @Test
    fun reversedUnlockedArrayCountsEveryInversion() {
        assertEquals(3, Solution().minOperations(intArrayOf(3, 2, 1), intArrayOf(0, 0, 0), 0))
    }

    @Test
    fun insufficientLockedBudgetReturnsMinusOne() {
        assertEquals(-1, Solution().minOperations(intArrayOf(2, 1), intArrayOf(1, 0), 0))
    }

    @Test
    fun sufficientLockedBudgetAddsRequiredLockCount() {
        assertEquals(2, Solution().minOperations(intArrayOf(2, 1), intArrayOf(1, 0), 1))
    }

    @Test
    fun duplicateValuesAndLockedMiddleElementAreHandled() {
        assertEquals(3, Solution().minOperations(intArrayOf(2, 2, 1), intArrayOf(0, 1, 0), 1))
    }
}
