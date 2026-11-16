package maximumnumberofmatchingindicesafterrightshifts

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MaximumNumberOfMatchingIndicesAfterRightShiftsTest {
    private val solution = Solution()

    @Test
    fun noShiftNeeded() {
        assertEquals(4, solution.maximumMatchingIndices(intArrayOf(1, 2, 3, 4), intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun rotationMatchesEveryIndex() {
        assertEquals(3, solution.maximumMatchingIndices(intArrayOf(1, 2, 3), intArrayOf(3, 1, 2)))
    }

    @Test
    fun duplicateValues() {
        assertEquals(2, solution.maximumMatchingIndices(intArrayOf(1, 1, 1), intArrayOf(1, 2, 1)))
    }

    @Test
    fun noValuesMatch() {
        assertEquals(0, solution.maximumMatchingIndices(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6)))
    }

    @Test
    fun singleElement() {
        assertEquals(1, solution.maximumMatchingIndices(intArrayOf(7), intArrayOf(7)))
    }
}
