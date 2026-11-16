package knightprobabilityinchessboard

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KnightProbabilityInChessboardTest {
    private val solution = Solution()

    @Test
    fun example1() {
        assertEquals(0.0625, solution.knightProbability(3, 2, 0, 0), 1e-9)
    }

    @Test
    fun noMoves() {
        assertEquals(1.0, solution.knightProbability(1, 0, 0, 0), 1e-9)
    }

    @Test
    fun oneStepFromCorner() {
        assertEquals(0.25, solution.knightProbability(3, 1, 0, 0), 1e-9)
    }

    @Test
    fun zeroSteps() {
        assertEquals(1.0, solution.knightProbability(8, 0, 0, 0), 1e-9)
    }

    @Test
    fun noValidMovesOnSmallBoard() {
        assertEquals(0.0, solution.knightProbability(2, 1, 0, 0), 1e-9)
    }

    @Test
    fun centerOfLargeBoard() {
        assertEquals(1.0, solution.knightProbability(8, 0, 3, 3), 1e-9)
    }
}
