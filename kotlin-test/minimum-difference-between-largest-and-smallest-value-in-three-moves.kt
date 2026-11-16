package minimumdifferencebetweenlargestandsmallestvalueinthreemoves
// Time:  O(n + klogk)
// Space: O(1)

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumDifferenceBetweenLargestAndSmallestValueInThreeMovesTest {
    private val solution = Solution()

    @Test
    fun leetCodeExamples() {
        assertEquals(0, solution.minDifference(intArrayOf(5, 3, 2, 4)))
        assertEquals(1, solution.minDifference(intArrayOf(1, 5, 0, 10, 14)))
        assertEquals(0, solution.minDifference(intArrayOf(3, 100, 20)))
    }

    @Test
    fun changeSmallValues() {
        assertEquals(1, solution.minDifference(intArrayOf(1, 2, 3, 4, 100)))
    }

    @Test
    fun duplicatesAllowZeroDifference() {
        assertEquals(0, solution.minDifference(intArrayOf(7, 7, 7, 7, 7)))
    }
}
