package maximumnumberofnonoverlappingsubarrayswithsumequalstarget

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MaximumNumberOfNonOverlappingSubarraysWithSumEqualsTargetTest {
    private val solution = Solution()

    @Test
    fun standardExampleRepeatedOnes() {
        assertEquals(2, solution.maxNonOverlapping(intArrayOf(1, 1, 1, 1, 1), 2))
    }

    @Test
    fun standardExampleWithNegatives() {
        assertEquals(2, solution.maxNonOverlapping(intArrayOf(-1, 3, 5, 1, 4, 2, -9), 6))
    }

    @Test
    fun zeroTargetUsesEachZero() {
        assertEquals(3, solution.maxNonOverlapping(intArrayOf(0, 0, 0), 0))
    }

    @Test
    fun noSubarrayMatches() {
        assertEquals(0, solution.maxNonOverlapping(intArrayOf(2, 2, 2), 0))
    }

    @Test
    fun greedySelectionAvoidsOverlap() {
        assertEquals(2, solution.maxNonOverlapping(intArrayOf(-1, 2, 1, -2, 3), 2))
    }
}
