package minimummovestocapturethequeen

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MinimumMovesToCaptureTheQueenTest {

    private val solution = Solution()

    @Test
    fun testRookSameRow() {
        assertEquals(1, solution.minMovesToCaptureTheQueen(5, 3, 3, 4, 5, 2))
    }

    @Test
    fun testRookSameColumn() {
        assertEquals(1, solution.minMovesToCaptureTheQueen(1, 1, 8, 8, 1, 8))
    }

    @Test
    fun testBishopDiagonal() {
        assertEquals(1, solution.minMovesToCaptureTheQueen(1, 1, 3, 3, 5, 5))
    }

    @Test
    fun testRookBlockedByBishop() {
        assertEquals(2, solution.minMovesToCaptureTheQueen(1, 1, 1, 4, 1, 8))
    }

    @Test
    fun testBishopBlockedByRook() {
        assertEquals(2, solution.minMovesToCaptureTheQueen(4, 4, 3, 3, 5, 5))
    }

    @Test
    fun testNoDirectLine() {
        assertEquals(2, solution.minMovesToCaptureTheQueen(1, 1, 8, 8, 2, 3))
    }
}
