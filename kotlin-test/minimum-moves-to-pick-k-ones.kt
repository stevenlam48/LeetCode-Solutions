package minimummovestopickkones

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MinimumMovesToPickKOnesTest {

    private val solution = Solution()

    @Test
    fun testSingleOneNeeded() {
        assertEquals(0L, solution.minimumMoves(intArrayOf(1, 0, 0), 1, 0))
    }

    @Test
    fun testOneInMiddle() {
        assertEquals(0L, solution.minimumMoves(intArrayOf(0, 1, 0), 1, 0))
    }

    @Test
    fun testTwoSeparatedOnes() {
        assertEquals(2L, solution.minimumMoves(intArrayOf(1, 0, 1), 2, 0))
    }

    @Test
    fun testThreeConsecutiveOnes() {
        assertEquals(1L, solution.minimumMoves(intArrayOf(1, 1, 1), 2, 0))
    }

    @Test
    fun testFarApart() {
        assertEquals(4L, solution.minimumMoves(intArrayOf(1, 0, 0, 0, 1), 2, 0))
    }

    @Test
    fun testUseChanges() {
        assertEquals(2L, solution.minimumMoves(intArrayOf(1, 0, 0, 0, 1), 2, 1))
    }
}
