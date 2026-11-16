package checkiftwochessboardsquareshavethesamecolor

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CheckIfTwoChessboardSquaresHaveTheSameColorTest {
    private val solution = Solution()

    @Test
    fun testSameColor() {
        assertTrue(solution.checkTwoChessboards("a1", "c3"))
    }

    @Test
    fun testDifferentColor() {
        assertFalse(solution.checkTwoChessboards("a1", "h3"))
    }

    @Test
    fun testSameFileDifferentRank() {
        assertFalse(solution.checkTwoChessboards("a1", "a2"))
    }

    @Test
    fun testSameSquare() {
        assertTrue(solution.checkTwoChessboards("h8", "h8"))
    }
}
