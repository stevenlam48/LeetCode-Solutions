package flipgameii

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class FlipGameIiTest {
    private val solution = Solution()

    @Test
    fun handlesInputsWithoutMoves() {
        assertFalse(solution.canWin(""))
        assertFalse(solution.canWin("+"))
        assertFalse(solution.canWin("--"))
    }

    @Test
    fun recognizesWinningFourPlusRun() {
        assertTrue(solution.canWin("++++"))
    }

    @Test
    fun recognizesLosingFivePlusRun() {
        assertFalse(solution.canWin("+++++"))
    }

    @Test
    fun xorsGrundyValuesOfIndependentRuns() {
        assertFalse(solution.canWin("++--++"))
        assertTrue(solution.canWin("++--++++"))
    }
}
