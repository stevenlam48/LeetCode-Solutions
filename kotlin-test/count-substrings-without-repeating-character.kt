package countsubstringswithoutrepeatingcharacter

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CountSubstringsWithoutRepeatingCharacterTest {
    private val solution = Solution()

    @Test
    fun `counts all substrings of distinct characters`() {
        assertEquals(6, solution.numberOfSpecialSubstrings("abc"))
    }

    @Test
    fun `excludes substrings with repeated characters`() {
        assertEquals(3, solution.numberOfSpecialSubstrings("aaa"))
        assertEquals(6, solution.numberOfSpecialSubstrings("abba"))
    }

    @Test
    fun `handles empty input`() {
        assertEquals(0, solution.numberOfSpecialSubstrings(""))
    }

    @Test
    fun `handles a longer repeated pattern`() {
        assertEquals(18, solution.numberOfSpecialSubstrings("abcabcbb"))
    }
}
