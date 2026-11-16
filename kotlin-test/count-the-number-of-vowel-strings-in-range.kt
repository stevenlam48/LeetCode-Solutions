package countthenumberofvowelstringsinrange

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountTheNumberOfVowelStringsInRangeTest {
    private val solution = Solution()

    @Test
    fun `first leetcode example`() {
        assertEquals(2, solution.vowelStrings(listOf("are", "amy", "u"), 0, 2))
    }

    @Test
    fun `second leetcode example`() {
        assertEquals(3, solution.vowelStrings(listOf("hey", "aeo", "mu", "ooo", "artro"), 1, 4))
    }

    @Test
    fun `range can contain one word`() {
        assertEquals(1, solution.vowelStrings(listOf("hey", "eye", "no"), 1, 1))
    }

    @Test
    fun `both endpoints must be vowels`() {
        assertEquals(1, solution.vowelStrings(listOf("idea", "coda", "atom", "psst"), 0, 3))
    }

    @Test
    fun `single character vowel words qualify`() {
        assertEquals(3, solution.vowelStrings(listOf("a", "b", "e", "u"), 0, 3))
    }
}
