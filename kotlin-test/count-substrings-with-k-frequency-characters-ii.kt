package countsubstringswithkfrequencycharactersii

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CountSubstringsWithKFrequencyCharactersIiTest {
    private val solution = Solution()

    @Test
    fun `counts substrings containing a repeated character`() {
        assertEquals(1L, solution.numberOfSubstrings("aa", 2))
        assertEquals(3L, solution.numberOfSubstrings("aaa", 2))
    }

    @Test
    fun `returns zero when no character reaches k`() {
        assertEquals(0L, solution.numberOfSubstrings("ab", 2))
    }

    @Test
    fun `counts every substring when k is one`() {
        assertEquals(6L, solution.numberOfSubstrings("abc", 1))
    }

    @Test
    fun `handles empty input`() {
        assertEquals(0L, solution.numberOfSubstrings("", 1))
    }

    @Test
    fun `counts valid windows with different endpoints`() {
        assertEquals(5L, solution.numberOfSubstrings("aaab", 2))
    }
}
