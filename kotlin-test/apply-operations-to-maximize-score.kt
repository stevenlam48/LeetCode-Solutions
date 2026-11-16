package applyoperationstomaximizescore

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class ApplyOperationsToMaximizeScoreTest {
    private val solution = Solution()

    @Test
    fun largestValuesAreAppliedFirst() {
        assertEquals(81, solution.maximumScore(intArrayOf(8, 3, 9, 3, 8), 2))
    }

    @Test
    fun exhaustionOfOneIndexMovesToNextValue() {
        assertEquals(12, solution.maximumScore(intArrayOf(2, 3), 3))
    }

    @Test
    fun distinctPrimeFactorsDeterminePriorityRange() {
        assertEquals(36, solution.maximumScore(intArrayOf(6, 2, 3), 2))
    }

    @Test
    fun oneLeavesProductUnchanged() {
        assertEquals(1, solution.maximumScore(intArrayOf(1), 4))
    }
}
