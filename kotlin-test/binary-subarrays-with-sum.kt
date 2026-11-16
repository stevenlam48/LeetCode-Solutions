package binarysubarrayswithsum

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BinarySubarraysWithSumTest {
    @Test
    fun standardExample() {
        assertEquals(4, Solution().numSubarraysWithSum(intArrayOf(1, 0, 1, 0, 1), 2))
    }

    @Test
    fun zeroGoalCountsEveryEmptyGapPair() {
        assertEquals(6, Solution().numSubarraysWithSum(intArrayOf(0, 0, 0), 0))
    }

    @Test
    fun goalCannotBeReached() {
        assertEquals(0, Solution().numSubarraysWithSum(intArrayOf(1, 1), 3))
    }

    @Test
    fun emptyArray() {
        assertEquals(0, Solution().numSubarraysWithSum(intArrayOf(), 0))
    }
}
