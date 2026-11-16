package minimumintervalselectiontocovertargetintervals

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumIntervalSelectionToCoverTargetIntervalsTest {
    private val solution = Solution()

    @Test
    fun oneTargetNeedsTwoIntervals() {
        assertEquals(
            2,
            solution.minSelection(
                arrayOf(intArrayOf(1, 3), intArrayOf(2, 5), intArrayOf(4, 6)),
                arrayOf(intArrayOf(1, 5))
            )
        )
    }

    @Test
    fun separateTargetsCanRequireSeparateIntervals() {
        assertEquals(
            3,
            solution.minSelection(
                arrayOf(intArrayOf(1, 4), intArrayOf(3, 6), intArrayOf(7, 8)),
                arrayOf(intArrayOf(1, 2), intArrayOf(5, 6), intArrayOf(7, 8))
            )
        )
    }

    @Test
    fun uncoveredGapIsImpossible() {
        assertEquals(
            -1,
            solution.minSelection(
                arrayOf(intArrayOf(1, 2), intArrayOf(4, 5)),
                arrayOf(intArrayOf(1, 5))
            )
        )
    }

    @Test
    fun singlePointTargetIsCoverable() {
        assertEquals(
            1,
            solution.minSelection(arrayOf(intArrayOf(1, 1)), arrayOf(intArrayOf(1, 1)))
        )
    }
}
