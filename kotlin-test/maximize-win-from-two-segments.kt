package maximizewinfromtwosegments

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximizeWinFromTwoSegmentsTest {
    @Test
    fun exampleOne() {
        assertEquals(7, Solution().maximizeWin(intArrayOf(1, 1, 2, 2, 3, 3, 5), 2))
    }

    @Test
    fun zeroK() {
        assertEquals(2, Solution().maximizeWin(intArrayOf(1, 2, 3, 4), 0))
    }

    @Test
    fun singlePrize() {
        assertEquals(1, Solution().maximizeWin(intArrayOf(1), 0))
    }

    @Test
    fun allWithinOneSegment() {
        assertEquals(3, Solution().maximizeWin(intArrayOf(1, 1, 1), 0))
    }
}
