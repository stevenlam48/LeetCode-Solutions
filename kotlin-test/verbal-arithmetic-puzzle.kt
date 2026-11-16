package verbalarithmeticpuzzle

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class VerbalArithmeticPuzzleTest {
    private val solution = Solution()

    @Test
    fun solvesSendMoreMoney() {
        assertTrue(solution.isSolvable(listOf("SEND", "MORE"), "MONEY"))
    }

    @Test
    fun solvesMultipleAddends() {
        assertTrue(solution.isSolvable(listOf("SIX", "SEVEN", "SEVEN"), "TWENTY"))
    }

    @Test
    fun rejectsUnsolvablePuzzle() {
        assertFalse(solution.isSolvable(listOf("LEET", "CODE"), "POINT"))
    }

    @Test
    fun acceptsEmptyEquation() {
        assertTrue(solution.isSolvable(emptyList(), ""))
    }
}
