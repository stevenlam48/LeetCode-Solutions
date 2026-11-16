package maximumarrayhoppingscorei

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumArrayHoppingScoreITest {
    private val solution = Solution()

    @Test
    fun directLongHopIsBest() {
        assertEquals(16, solution.maxScore(intArrayOf(1, 5, 8)))
    }

    @Test
    fun mixedHopLengths() {
        assertEquals(13, solution.maxScore(intArrayOf(5, 5, 2, 4)))
    }

    @Test
    fun singleElement() {
        assertEquals(0, solution.maxScore(intArrayOf(7)))
    }

    @Test
    fun decreasingValuesFavorFirstLargestSuffixMaximum() {
        assertEquals(9, solution.maxScore(intArrayOf(1, 4, 3, 2)))
    }
}
