package countsubstringsstartingandendingwithgivencharacter

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CountSubstringsStartingAndEndingWithGivenCharacterTest {
    private val solution = Solution()

    @Test
    fun `counts every pair of matching endpoint occurrences`() {
        assertEquals(6L, solution.countSubstrings("abaca", 'a'))
    }

    @Test
    fun `counts one occurrence as one substring`() {
        assertEquals(1L, solution.countSubstrings("abaca", 'b'))
    }

    @Test
    fun `returns zero for an absent character`() {
        assertEquals(0L, solution.countSubstrings("abaca", 'z'))
    }

    @Test
    fun `handles empty input`() {
        assertEquals(0L, solution.countSubstrings("", 'a'))
    }

    @Test
    fun `handles all matching characters`() {
        assertEquals(10L, solution.countSubstrings("aaaa", 'a'))
    }
}
