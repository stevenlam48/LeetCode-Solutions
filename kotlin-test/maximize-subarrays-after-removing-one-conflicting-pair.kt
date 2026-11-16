package maximizesubarraysafterremovingoneconflictingpair

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximizeSubarraysAfterRemovingOneConflictingPairTest {
    private val solution = Solution()

    @Test
    fun removesThePairThatAddsMostSubarrays() {
        val pairs = arrayOf(intArrayOf(2, 3), intArrayOf(1, 4))
        assertEquals(9L, solution.maxSubarrays(4, pairs))
    }

    @Test
    fun acceptsReversedPairCoordinates() {
        val pairs = arrayOf(intArrayOf(3, 1))
        assertEquals(6L, solution.maxSubarrays(3, pairs))
    }

    @Test
    fun removingOneDuplicateLeavesTheOtherConstraint() {
        val pairs = arrayOf(intArrayOf(1, 3), intArrayOf(1, 3))
        assertEquals(5L, solution.maxSubarrays(3, pairs))
    }

    @Test
    fun handlesMultiplePairsSharingEndpoints() {
        val pairs = arrayOf(intArrayOf(1, 3), intArrayOf(1, 4), intArrayOf(2, 4))
        assertEquals(8L, solution.maxSubarrays(4, pairs))
    }
}
