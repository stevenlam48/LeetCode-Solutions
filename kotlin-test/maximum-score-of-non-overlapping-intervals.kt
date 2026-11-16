package maximumscoreofnonoverlappingintervals

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MaximumScoreOfNonOverlappingIntervalsTest {
    private val solution = Solution()

    @Test
    fun singleInterval() {
        assertArrayEquals(
            intArrayOf(0),
            solution.maximumWeight(arrayOf(intArrayOf(2, 5, 10)))
        )
    }

    @Test
    fun returnedIndicesAreSortedRatherThanChronological() {
        val intervals = arrayOf(intArrayOf(5, 6, 4), intArrayOf(1, 2, 4))
        assertArrayEquals(intArrayOf(0, 1), solution.maximumWeight(intervals))
    }

    @Test
    fun choosesHigherWeightOverlappingInterval() {
        val intervals = arrayOf(
            intArrayOf(1, 3, 5),
            intArrayOf(2, 4, 7),
            intArrayOf(5, 6, 4),
            intArrayOf(7, 9, 6)
        )
        assertArrayEquals(intArrayOf(1, 2, 3), solution.maximumWeight(intervals))
    }

    @Test
    fun equalWeightUsesLexicographicallySmallestIndices() {
        val intervals = arrayOf(
            intArrayOf(1, 4, 5),
            intArrayOf(2, 3, 5),
            intArrayOf(5, 6, 5)
        )
        assertArrayEquals(intArrayOf(0, 2), solution.maximumWeight(intervals))
    }

    @Test
    fun duplicateIntervalsKeepTheFirstIndex() {
        val intervals = arrayOf(
            intArrayOf(1, 2, 4),
            intArrayOf(1, 2, 4),
            intArrayOf(3, 4, 3)
        )
        assertArrayEquals(intArrayOf(0, 2), solution.maximumWeight(intervals))
    }

    @Test
    fun selectsAtMostFourIntervalsByWeight() {
        val intervals = arrayOf(
            intArrayOf(1, 2, 1),
            intArrayOf(3, 4, 1),
            intArrayOf(5, 6, 1),
            intArrayOf(7, 8, 1),
            intArrayOf(9, 10, 100)
        )
        assertArrayEquals(intArrayOf(0, 1, 2, 4), solution.maximumWeight(intervals))
    }
}
