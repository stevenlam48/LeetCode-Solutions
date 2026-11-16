package waystosplitarrayintogoodsubarrays

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WaysToSplitArrayIntoGoodSubarraysTest {
    private val solution = Solution()

    @Test
    fun example1() {
        assertEquals(3, solution.numberOfGoodSubarraySplits(intArrayOf(0, 1, 0, 0, 1)))
    }

    @Test
    fun example2() {
        assertEquals(1, solution.numberOfGoodSubarraySplits(intArrayOf(0, 1, 0)))
    }

    @Test
    fun noOnes() {
        assertEquals(0, solution.numberOfGoodSubarraySplits(intArrayOf(0, 0, 0)))
    }

    @Test
    fun singleOne() {
        assertEquals(1, solution.numberOfGoodSubarraySplits(intArrayOf(1)))
    }

    @Test
    fun multipleGaps() {
        assertEquals(6, solution.numberOfGoodSubarraySplits(intArrayOf(1, 0, 0, 1, 0, 1)))
    }
}
