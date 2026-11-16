package determineifacellisreachableatagiventime

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class DetermineIfACellIsReachableAtAGivenTimeTest {
    private val solution = Solution()

    @Test
    fun diagonalDestinationIsReachable() {
        assertTrue(solution.isReachableAtTime(2, 4, 7, 7, 6))
    }

    @Test
    fun destinationIsTooFar() {
        assertFalse(solution.isReachableAtTime(3, 1, 7, 3, 3))
    }

    @Test
    fun sameCellCannotBeVisitedInOneSecond() {
        assertFalse(solution.isReachableAtTime(1, 1, 1, 1, 1))
    }

    @Test
    fun sameCellIsReachableWithZeroOrExtraTime() {
        assertTrue(solution.isReachableAtTime(1, 1, 1, 1, 0))
        assertTrue(solution.isReachableAtTime(1, 1, 1, 1, 2))
    }

    @Test
    fun straightLineRequiresMaximumAxisDistance() {
        assertTrue(solution.isReachableAtTime(9, 5, 3, 5, 6))
    }
}
