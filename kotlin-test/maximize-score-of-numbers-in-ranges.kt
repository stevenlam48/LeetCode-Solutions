package maximizescoreofnumbersinranges

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class MaximizeScoreOfNumbersInRangesTest {
    @Test
    fun unsortedRanges() {
        assertEquals(4, Solution().maxPossibleScore(intArrayOf(6, 0, 3), 2))
    }

    @Test
    fun separatedRanges() {
        assertEquals(3, Solution().maxPossibleScore(intArrayOf(9, 3, 1, 7), 2))
    }

    @Test
    fun duplicateStarts() {
        assertEquals(1, Solution().maxPossibleScore(intArrayOf(2, 2, 2), 2))
    }

    @Test
    fun singleRange() {
        assertEquals(10, Solution().maxPossibleScore(intArrayOf(4), 10))
    }

    @Test
    fun zeroWidthRanges() {
        assertEquals(3, Solution().maxPossibleScore(intArrayOf(1, 4), 0))
    }
}
