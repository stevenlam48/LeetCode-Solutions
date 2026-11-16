package minimuminversioncountinsubarraysoffixedlength

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumInversionCountInSubarraysOfFixedLengthTest {
    private val solution = Solution()

    @Test
    fun returnsMinimumAcrossSlidingWindows() {
        assertEquals(0L, solution.minInversionCount(intArrayOf(3, 1, 2, 5, 4), 3))
    }

    @Test
    fun countsAllInversionsInSingleWindow() {
        assertEquals(2L, solution.minInversionCount(intArrayOf(3, 1, 2), 3))
        assertEquals(6L, solution.minInversionCount(intArrayOf(4, 3, 2, 1), 4))
    }

    @Test
    fun equalValuesDoNotFormInversions() {
        assertEquals(0L, solution.minInversionCount(intArrayOf(2, 2, 1, 1), 2))
    }

    @Test
    fun singleElementWindowsHaveNoInversions() {
        assertEquals(0L, solution.minInversionCount(intArrayOf(5, -1, 5, 0), 1))
    }
}
