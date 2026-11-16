package maximumandminimumsumsofatmostsizeksubsequences

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumAndMinimumSumsOfAtMostSizeKSubsequencesTest {
    private val solution = Solution()

    @Test
    fun pairsAndSingletonsInThreeElements() {
        assertEquals(24, solution.minMaxSums(intArrayOf(1, 2, 3), 2))
    }

    @Test
    fun allNonemptySubsequences() {
        assertEquals(28, solution.minMaxSums(intArrayOf(1, 2, 3), 3))
    }

    @Test
    fun singletonsOnly() {
        assertEquals(12, solution.minMaxSums(intArrayOf(1, 2, 3), 1))
    }

    @Test
    fun duplicateValues() {
        assertEquals(12, solution.minMaxSums(intArrayOf(2, 2), 2))
    }

    @Test
    fun singleElementWithLargerK() {
        assertEquals(10, solution.minMaxSums(intArrayOf(5), 4))
    }

    @Test
    fun unsortedInput() {
        assertEquals(24, solution.minMaxSums(intArrayOf(3, 1, 2), 2))
    }
}
