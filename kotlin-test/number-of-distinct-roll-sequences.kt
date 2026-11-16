package numberofdistinctrollsequences

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class NumberOfDistinctRollSequencesTest {
    private val solution = Solution()

    @Test
    fun countsSingleRollSequences() {
        assertEquals(6, solution.distinctSequences(1))
    }

    @Test
    fun countsCoprimePairsForTwoRolls() {
        assertEquals(22, solution.distinctSequences(2))
    }

    @Test
    fun allowsFirstAndThirdRollsToMatch() {
        assertEquals(66, solution.distinctSequences(3))
    }

    @Test
    fun matchesFourRollExample() {
        assertEquals(184, solution.distinctSequences(4))
    }
}
