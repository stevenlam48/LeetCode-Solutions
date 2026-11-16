package minimizeconnectedgroupsbyinsertinginterval

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimizeConnectedGroupsByInsertingIntervalTest {
    private fun intervals(vararg pairs: Pair<Int, Int>): Array<IntArray> =
        pairs.map { intArrayOf(it.first, it.second) }.toTypedArray()

    @Test
    fun noMergeWithZeroGap() {
        assertEquals(2, Solution().minConnectedGroups(intervals(1 to 2, 3 to 4), 0))
    }

    @Test
    fun mergeWithSufficientLength() {
        assertEquals(1, Solution().minConnectedGroups(intervals(1 to 2, 3 to 4), 2))
    }

    @Test
    fun gapTooLarge() {
        assertEquals(2, Solution().minConnectedGroups(intervals(1 to 3, 6 to 7), 2))
    }

    @Test
    fun gapExactlyK() {
        assertEquals(1, Solution().minConnectedGroups(intervals(1 to 3, 6 to 7), 3))
    }

    @Test
    fun mergesTwoOfThree() {
        assertEquals(2, Solution().minConnectedGroups(intervals(1 to 1, 2 to 2, 3 to 3), 1))
    }

    @Test
    fun consecutiveIntervals() {
        assertEquals(2, Solution().minConnectedGroups(intervals(1 to 2, 3 to 4, 5 to 6), 1))
    }
}
