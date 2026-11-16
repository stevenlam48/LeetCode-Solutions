package minimumcosttodividearrayintosubarrays

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumCostToDivideArrayIntoSubarraysTest {
    private val solution = Solution()

    @Test
    fun oneElement() {
        assertEquals(56L, solution.minimumCost(intArrayOf(5), intArrayOf(7), 3))
    }

    @Test
    fun splittingAtFirstElement() {
        assertEquals(35L, solution.minimumCost(intArrayOf(1, 2), intArrayOf(3, 4), 2))
    }

    @Test
    fun mixedLengthPartition() {
        assertEquals(36L, solution.minimumCost(intArrayOf(1, 2, 3), intArrayOf(1, 2, 3), 1))
    }

    @Test
    fun zeroPenaltyForSubarrays() {
        assertEquals(25L, solution.minimumCost(intArrayOf(1, 2, 3), intArrayOf(1, 2, 3), 0))
    }
}
