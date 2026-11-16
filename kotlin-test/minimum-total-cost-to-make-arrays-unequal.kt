package minimumtotalcosttomakearraysunequal

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumTotalCostToMakeArraysUnequalTest {
    @Test
    fun identicalArraysWithoutMajority() {
        assertEquals(10L, Solution().minimumTotalCost(intArrayOf(1, 2, 3, 4, 5), intArrayOf(1, 2, 3, 4, 5)))
    }

    @Test
    fun oneConflictCanUseAnotherIndex() {
        assertEquals(2L, Solution().minimumTotalCost(intArrayOf(1, 2, 3, 4, 5), intArrayOf(5, 4, 3, 2, 1)))
    }

    @Test
    fun noMajority() {
        assertEquals(8L, Solution().minimumTotalCost(intArrayOf(1, 1, 1, 2, 2), intArrayOf(1, 1, 2, 2, 2)))
    }

    @Test
    fun majorityNeedsExtraIndices() {
        assertEquals(8L, Solution().minimumTotalCost(intArrayOf(1, 1, 1, 2, 3), intArrayOf(1, 1, 2, 4, 5)))
    }

    @Test
    fun notEnoughCompatibleIndices() {
        assertEquals(-1L, Solution().minimumTotalCost(intArrayOf(1, 1, 2), intArrayOf(1, 1, 3)))
    }

    @Test
    fun alreadyUnequal() {
        assertEquals(0L, Solution().minimumTotalCost(intArrayOf(1, 2), intArrayOf(2, 1)))
    }
}
