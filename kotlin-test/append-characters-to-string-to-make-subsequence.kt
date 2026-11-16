package appendcharacterstostringtomakesubsequence

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class AppendCharactersToStringToMakeSubsequenceTest {
    private val solution = Solution()

    @Test
    fun appendRemainingSuffix() {
        assertEquals(4, solution.appendCharacters("coaching", "coding"))
    }

    @Test
    fun alreadyASubsequence() {
        assertEquals(0, solution.appendCharacters("abcde", "a"))
    }

    @Test
    fun noCharactersMatched() {
        assertEquals(5, solution.appendCharacters("z", "abcde"))
    }

    @Test
    fun emptyTarget() {
        assertEquals(0, solution.appendCharacters("abc", ""))
    }
}
