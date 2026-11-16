package maximumscoreofasplit

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumScoreOfASplitTest {
    private val solution = Solution()

    @Test
    fun bestSplitUsesLastElementAsSuffixMinimum() {
        assertEquals(13L, solution.maximumScore(intArrayOf(10, 3, 1, 1)))
    }

    @Test
    fun bestSplitIsBeforeLastTwoElements() {
        assertEquals(10L, solution.maximumScore(intArrayOf(2, 4, 1, 5, 2)))
    }

    @Test
    fun negativeSuffixMinimumIncreasesScore() {
        assertEquals(5L, solution.maximumScore(intArrayOf(-2, 3, -4, 5)))
    }

    @Test
    fun twoElements() {
        assertEquals(4L, solution.maximumScore(intArrayOf(7, 3)))
    }

    @Test
    fun allNegativeElements() {
        assertEquals(2L, solution.maximumScore(intArrayOf(-1, -2, -3)))
    }
}
