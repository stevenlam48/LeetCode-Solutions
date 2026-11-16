package countsubstringsthatdifferbyonecharacter

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CountSubstringsThatDifferByOneCharacterTest {
    private val solution = Solution()

    @Test
    fun `counts standard examples`() {
        assertEquals(6, solution.countSubstrings("aba", "baba"))
        assertEquals(3, solution.countSubstrings("ab", "bb"))
    }

    @Test
    fun `returns zero when all aligned substrings are equal`() {
        assertEquals(0, solution.countSubstrings("a", "a"))
        assertEquals(0, solution.countSubstrings("zz", "zz"))
    }

    @Test
    fun `counts single character mismatches`() {
        assertEquals(1, solution.countSubstrings("a", "b"))
    }

    @Test
    fun `handles empty input`() {
        assertEquals(0, solution.countSubstrings("", "abc"))
        assertEquals(0, solution.countSubstrings("abc", ""))
    }
}
