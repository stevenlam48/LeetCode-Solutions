package countthenumberofspecialcharactersi
// Time:  O(n + 26)
// Space: O(26)

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountTheNumberOfSpecialCharactersITest {
    @Test
    fun example() {
        assertEquals(3, Solution().numberOfSpecialChars("aaAbcBC"))
    }

    @Test
    fun lowercaseOnly() {
        assertEquals(0, Solution().numberOfSpecialChars("abc"))
    }

    @Test
    fun repeatedCharacters() {
        assertEquals(2, Solution().numberOfSpecialChars("aAaAbB"))
    }

    @Test
    fun emptyWord() {
        assertEquals(0, Solution().numberOfSpecialChars(""))
    }
}
