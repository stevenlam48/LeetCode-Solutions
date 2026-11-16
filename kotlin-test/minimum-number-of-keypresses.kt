package minimumnumberofkeypresses

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumNumberOfKeypressesTest {
    private val solution = Solution()

    @Test
    fun fullAlphabet() {
        assertEquals(51, solution.minimumKeypresses("abcdefghijklmnopqrstuvwxyz"))
    }

    @Test
    fun repeatedLetter() {
        assertEquals(5, solution.minimumKeypresses("apple"))
    }

    @Test
    fun nineLettersWithTwoOccurrences() {
        assertEquals(18, solution.minimumKeypresses("aabbccddeeffgghhii"))
    }

    @Test
    fun singleDistinctLetter() {
        assertEquals(5, solution.minimumKeypresses("zzzzz"))
    }

    @Test
    fun emptyString() {
        assertEquals(0, solution.minimumKeypresses(""))
    }
}
