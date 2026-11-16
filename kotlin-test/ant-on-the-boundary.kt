package antontheboundary

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class AntOnTheBoundaryTest {
    private val solution = Solution()

    @Test
    fun returnsAfterSeveralMoves() {
        assertEquals(1, solution.returnToBoundaryCount(intArrayOf(2, 3, -5)))
    }

    @Test
    fun neverReturns() {
        assertEquals(0, solution.returnToBoundaryCount(intArrayOf(3, 2, -3, -4)))
    }

    @Test
    fun repeatedReturns() {
        assertEquals(2, solution.returnToBoundaryCount(intArrayOf(1, -1, 2, -2)))
    }

    @Test
    fun emptyMoves() {
        assertEquals(0, solution.returnToBoundaryCount(IntArray(0)))
    }
}
