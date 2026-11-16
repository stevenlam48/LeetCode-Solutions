package maximumscoreafterbinaryswaps

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumScoreAfterBinarySwapsTest {
    private val solution = Solution()

    @Test
    fun prefixesProvideLargerValuesForLaterSelections() {
        assertEquals(7L, solution.maximumScore(intArrayOf(2, 1, 5, 4), "0110"))
    }

    @Test
    fun retainedHeapValuesCanBeSelectedAfterEarlierSteps() {
        assertEquals(7L, solution.maximumScore(intArrayOf(4, 3, 2, 1), "1001"))
    }

    @Test
    fun noSelectedPositionsScoresZero() {
        assertEquals(0L, solution.maximumScore(intArrayOf(9, 1, 7), "000"))
    }

    @Test
    fun laterSelectionCanAvoidNegativePrefixValue() {
        assertEquals(-1L, solution.maximumScore(intArrayOf(-5, -1, -2), "010"))
    }

    @Test
    fun scoreUsesLongArithmetic() {
        assertEquals(
            2L * Int.MAX_VALUE,
            solution.maximumScore(intArrayOf(Int.MAX_VALUE, Int.MAX_VALUE), "11")
        )
    }
}
