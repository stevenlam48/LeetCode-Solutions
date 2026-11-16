package determinecolorofachessboardsquare

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class DetermineColorOfAChessboardSquareTest {
    private val solution = Solution()

    @Test
    fun a1IsBlack() {
        assertFalse(solution.squareIsWhite("a1"))
    }

    @Test
    fun c3IsBlack() {
        assertFalse(solution.squareIsWhite("c3"))
    }

    @Test
    fun h7IsWhite() {
        assertTrue(solution.squareIsWhite("h7"))
    }

    @Test
    fun c2IsWhite() {
        assertTrue(solution.squareIsWhite("c2"))
    }
}
