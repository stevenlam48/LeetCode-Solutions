package maximumlengthsubstringwithtwooccurrences

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumLengthSubstringWithTwoOccurrencesTest {
    private val solution = Solution()

    @Test
    fun `finds the longest valid substring`() {
        assertEquals(5, solution.maximumLengthSubstring("bcbbccba"))
    }

    @Test
    fun `limits a repeated character to two occurrences`() {
        assertEquals(2, solution.maximumLengthSubstring("aaaaa"))
    }

    @Test
    fun `keeps every distinct character twice`() {
        assertEquals(6, solution.maximumLengthSubstring("abcabc"))
    }

    @Test
    fun `handles an empty string`() {
        assertEquals(0, solution.maximumLengthSubstring(""))
    }
}
