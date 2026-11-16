package largestcombinationwithbitwiseandgreaterthanzero

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LargestCombinationWithBitwiseAndGreaterThanZeroTest {
    @Test
    fun exampleCandidates() {
        assertEquals(4, Solution().largestCombination(intArrayOf(16, 17, 71, 62, 12, 24, 14)))
    }

    @Test
    fun sharedHighBit() {
        assertEquals(3, Solution().largestCombination(intArrayOf(8, 12, 10, 3)))
    }

    @Test
    fun singleCandidate() {
        assertEquals(1, Solution().largestCombination(intArrayOf(1)))
    }

    @Test
    fun disjointBits() {
        assertEquals(1, Solution().largestCombination(intArrayOf(1, 2, 4, 8)))
    }
}
