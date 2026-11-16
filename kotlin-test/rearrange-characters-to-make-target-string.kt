package rearrangecharacterstomaketargetstring
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class RearrangeCharactersToMakeTargetStringTest {
    @Test
    fun leetCodeExamples() {
        assertEquals(2, Solution().rearrangeCharacters("ilovecodingonleetcode", "code"))
        assertEquals(1, Solution().rearrangeCharacters("abcba", "abc"))
        assertEquals(1, Solution().rearrangeCharacters("abbaccaddaeea", "aaaaa"))
    }

    @Test
    fun repeatedTargetCharactersLimitCopies() {
        assertEquals(2, Solution().rearrangeCharacters("aaaabbc", "aab"))
        assertEquals(0, Solution().rearrangeCharacters("ab", "aa"))
    }

    @Test
    fun missingOrEmptySource() {
        assertEquals(0, Solution().rearrangeCharacters("", "a"))
        assertEquals(0, Solution().rearrangeCharacters("xyz", "a"))
    }
}
