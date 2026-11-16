package maximizesubarraysumafterremovingalloccurrencesofoneelement

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximizeSubarraySumAfterRemovingAllOccurrencesOfOneElementTest {
    private val solution = Solution()

    @Test
    fun removesAllOccurrencesToJoinPositiveSegments() {
        assertEquals(8L, solution.maxSubarraySum(intArrayOf(1, -2, 3, -2, 4)))
    }

    @Test
    fun removesRepeatedNegativeValuesAcrossTheArray() {
        assertEquals(13L, solution.maxSubarraySum(intArrayOf(3, -2, 4, 1, -2, 5)))
    }

    @Test
    fun keepsBestSingleNegativeElement() {
        assertEquals(-1L, solution.maxSubarraySum(intArrayOf(-4, -1, -3)))
    }

    @Test
    fun sumsAllPositiveElements() {
        assertEquals(10L, solution.maxSubarraySum(intArrayOf(1, 2, 3, 4)))
    }
}
