package greatestcommondivisorofstrings

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GreatestCommonDivisorOfStringsTest {
    @Test
    fun `standard examples`() {
        val solution = Solution()
        assertEquals("ABC", solution.gcdOfStrings("ABCABC", "ABC"))
        assertEquals("AB", solution.gcdOfStrings("ABABAB", "ABAB"))
        assertEquals("", solution.gcdOfStrings("LEET", "CODE"))
    }

    @Test
    fun `one string divides longer string with different length`() {
        assertEquals("ABAB", Solution().gcdOfStrings("ABAB", "ABABABAB"))
    }

    @Test
    fun `empty input`() {
        val solution = Solution()
        assertEquals("", solution.gcdOfStrings("", "ABC"))
        assertEquals("", solution.gcdOfStrings("ABC", ""))
    }
}
