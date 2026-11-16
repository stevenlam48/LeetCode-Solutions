package matchstickstosquare

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class MatchsticksToSquareTest {
    private val solution = Solution()

    @Test
    fun formsSquareFromExample() {
        assertTrue(solution.makesquare(intArrayOf(1, 1, 2, 2, 2)))
    }

    @Test
    fun rejectsExampleWithInsufficientMatches() {
        assertFalse(solution.makesquare(intArrayOf(3, 3, 3, 3, 4)))
    }

    @Test
    fun acceptsFourEqualMatches() {
        assertTrue(solution.makesquare(intArrayOf(1, 1, 1, 1)))
    }

    @Test
    fun rejectsNonDivisibleTotalLength() {
        assertFalse(solution.makesquare(intArrayOf(1, 1, 1)))
    }

    @Test
    fun rejectsWhenOneSideCannotBeFormed() {
        assertFalse(solution.makesquare(intArrayOf(5, 1, 1, 1)))
    }

    @Test
    fun rejectsEmptyInput() {
        assertFalse(solution.makesquare(intArrayOf()))
    }
}
