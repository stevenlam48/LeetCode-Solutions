package countsubstringswithkfrequencycharactersi

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CountSubstringsWithKFrequencyCharactersITest {
    private val solution = Solution()

    @Test
    fun `counts substrings containing a repeated character`() {
        assertEquals(1, solution.numberOfSubstrings("aa", 2))
        assertEquals(3, solution.numberOfSubstrings("aaa", 2))
    }

    @Test
    fun `returns zero when no character reaches k`() {
        assertEquals(0, solution.numberOfSubstrings("ab", 2))
    }

    @Test
    fun `counts every substring when k is one`() {
        assertEquals(6, solution.numberOfSubstrings("abc", 1))
    }

    @Test
    fun `handles empty input`() {
        assertEquals(0, solution.numberOfSubstrings("", 1))
    }
}
