package numberofdivisiblesubstrings

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class NumberOfDivisibleSubstringsTest {
    private val solution = Solution()

    @Test
    fun matchesMixedCharacterExample() {
        assertEquals(6, solution.countDivisibleSubstrings("asdf"))
    }

    @Test
    fun countsEverySubstringOfRepeatedA() {
        assertEquals(6, solution.countDivisibleSubstrings("aaa"))
    }

    @Test
    fun countsDivisibleSubstringsAcrossDifferentDivisors() {
        assertEquals(4, solution.countDivisibleSubstrings("abc"))
    }

    @Test
    fun returnsZeroForEmptyWord() {
        assertEquals(0, solution.countDivisibleSubstrings(""))
    }
}
