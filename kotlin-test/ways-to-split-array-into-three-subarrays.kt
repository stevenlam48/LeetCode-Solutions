package waystosplitarrayintothreesubarrays

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WaysToSplitArrayIntoThreeSubarraysTest {
    private val solution = Solution()

    @Test
    fun example1() {
        assertEquals(1, solution.waysToSplit(intArrayOf(1, 1, 1)))
    }

    @Test
    fun example2() {
        assertEquals(3, solution.waysToSplit(intArrayOf(1, 2, 2, 2, 5, 0)))
    }

    @Test
    fun example3() {
        assertEquals(0, solution.waysToSplit(intArrayOf(3, 2, 1)))
    }

    @Test
    fun fourEqualElements() {
        assertEquals(1, solution.waysToSplit(intArrayOf(1, 1, 1, 1)))
    }

    @Test
    fun allZeros() {
        assertEquals(1, solution.waysToSplit(intArrayOf(0, 0, 0)))
    }

    @Test
    fun increasingArray() {
        assertEquals(1, solution.waysToSplit(intArrayOf(1, 2, 3)))
    }
}
