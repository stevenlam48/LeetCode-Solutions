package minimumknightmoves

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumKnightMovesTest {
    private val solution = Solution()

    @Test
    fun handlesStandardExamples() {
        assertEquals(1, solution.minKnightMoves(2, 1))
        assertEquals(4, solution.minKnightMoves(5, 5))
    }

    @Test
    fun originNeedsNoMove() {
        assertEquals(0, solution.minKnightMoves(0, 0))
    }

    @Test
    fun handlesFormulaSpecialCases() {
        assertEquals(3, solution.minKnightMoves(1, 0))
        assertEquals(4, solution.minKnightMoves(2, 2))
    }

    @Test
    fun symmetricCoordinatesHaveEqualAnswers() {
        assertEquals(solution.minKnightMoves(5, 2), solution.minKnightMoves(-2, -5))
        assertEquals(solution.minKnightMoves(1, 0), solution.minKnightMoves(0, -1))
    }
}
