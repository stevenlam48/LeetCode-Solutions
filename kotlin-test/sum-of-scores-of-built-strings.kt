package sumofscoresofbuiltstrings

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SumOfScoresOfBuiltStringsTest {
    private val solution = Solution()

    @Test
    fun alternatingPrefixes() {
        assertEquals(12L, solution.sumScores("ababab"))
    }

    @Test
    fun everySuffixMatches() {
        assertEquals(15L, solution.sumScores("aaaaa"))
    }

    @Test
    fun noRepeatedPrefix() {
        assertEquals(3L, solution.sumScores("abc"))
    }

    @Test
    fun mixedMatches() {
        assertEquals(12L, solution.sumScores("abacaba"))
    }
}
