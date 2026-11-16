package countuniquecharactersofallsubstringsofagivenstring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountUniqueCharactersOfAllSubstringsOfAGivenStringTest {
    @Test
    fun `all distinct letters`() {
        assertEquals(10, Solution().uniqueLetterString("ABC"))
    }

    @Test
    fun `repeated letters in separate substrings`() {
        assertEquals(8, Solution().uniqueLetterString("ABA"))
    }

    @Test
    fun `leetcode example`() {
        assertEquals(92, Solution().uniqueLetterString("LEETCODE"))
    }

    @Test
    fun `empty string`() {
        assertEquals(0, Solution().uniqueLetterString(""))
    }

    @Test
    fun `all identical letters`() {
        assertEquals(4, Solution().uniqueLetterString("AAAA"))
    }
}
