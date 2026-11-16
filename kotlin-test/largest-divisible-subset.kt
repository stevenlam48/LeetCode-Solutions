package largestdivisiblesubset

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class LargestDivisibleSubsetTest {
    @Test
    fun choosesFirstLargestSubsetOnTie() {
        assertArrayEquals(intArrayOf(1, 2), Solution().largestDivisibleSubset(intArrayOf(1, 2, 3)))
    }

    @Test
    fun fullDivisibilityChain() {
        assertArrayEquals(intArrayOf(1, 2, 4, 8), Solution().largestDivisibleSubset(intArrayOf(8, 1, 4, 2)))
    }

    @Test
    fun emptyInput() {
        assertArrayEquals(intArrayOf(), Solution().largestDivisibleSubset(intArrayOf()))
    }

    @Test
    fun duplicatesAreDistinctSubsetElements() {
        assertArrayEquals(intArrayOf(1, 1, 2), Solution().largestDivisibleSubset(intArrayOf(1, 1, 2)))
    }
}
