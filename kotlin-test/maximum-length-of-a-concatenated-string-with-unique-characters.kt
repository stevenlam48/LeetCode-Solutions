package maximumlengthofaconcatenatedstringwithuniquecharacters

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumLengthOfAConcatenatedStringWithUniqueCharactersTest {
    private val solution = Solution()

    @Test
    fun `concatenates strings with unique characters`() {
        assertEquals(4, solution.maxLength(listOf("un", "iq", "ue")))
    }

    @Test
    fun `selects the longest compatible subset`() {
        assertEquals(6, solution.maxLength(listOf("cha", "r", "act", "ers")))
    }

    @Test
    fun `handles the complete alphabet`() {
        assertEquals(26, solution.maxLength(listOf("abcdefghijklmnopqrstuvwxyz")))
    }

    @Test
    fun `skips strings that repeat a character`() {
        assertEquals(0, solution.maxLength(listOf("aa", "bb")))
        assertEquals(0, solution.maxLength(emptyList()))
    }
}
