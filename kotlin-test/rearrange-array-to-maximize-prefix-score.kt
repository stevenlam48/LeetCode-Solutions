package rearrangearraytomaximizeprefixscore
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class RearrangeArrayToMaximizePrefixScoreTest {
    @Test
    fun leetCodeExample() {
        assertEquals(6, Solution().maxScore(intArrayOf(2, -1, 0, 1, -3, 3, -3)))
    }

    @Test
    fun stopsAtFirstNonPositivePrefix() {
        assertEquals(3, Solution().maxScore(intArrayOf(1, -2, 3, -4)))
        assertEquals(1, Solution().maxScore(intArrayOf(5, -5, -5)))
    }

    @Test
    fun nonPositiveAndEmptyInputs() {
        assertEquals(0, Solution().maxScore(intArrayOf(0, 0, -2)))
        assertEquals(0, Solution().maxScore(intArrayOf(-1, -2, -3)))
        assertEquals(0, Solution().maxScore(intArrayOf()))
    }
}
