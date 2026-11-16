package findlatestgroupofsizem

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindLatestGroupOfSizeMTest {
    @Test
    fun findsLastStepBeforeAllGroupsChangeSize() {
        assertEquals(4, Solution().findLatestStep(intArrayOf(3, 5, 1, 2, 4), 1))
    }

    @Test
    fun handlesGroupsMergingOnBothSides() {
        assertEquals(2, Solution().findLatestStep(intArrayOf(1, 3, 2, 4), 1))
    }

    @Test
    fun returnsMinusOneWhenRequestedSizeNeverExists() {
        assertEquals(-1, Solution().findLatestStep(intArrayOf(3, 1, 2, 5, 4), 2))
    }

    @Test
    fun handlesSingleElementArray() {
        assertEquals(1, Solution().findLatestStep(intArrayOf(1), 1))
    }
}
