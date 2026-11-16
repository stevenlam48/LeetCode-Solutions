package countthenumberofspecialcharactersii
// Time:  O(n + 26)
// Space: O(26)

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountTheNumberOfSpecialCharactersIITest {
    @Test
    fun example() {
        assertEquals(3, Solution().numberOfSpecialChars("aaAbcBC"))
    }

    @Test
    fun uppercaseAppearsBeforeLowercase() {
        assertEquals(2, Solution().numberOfSpecialChars("AbBcC"))
    }

    @Test
    fun laterLowercaseInvalidatesLetter() {
        assertEquals(0, Solution().numberOfSpecialChars("aAaa"))
    }

    @Test
    fun allLowercaseOccurrencesPrecedeUppercase() {
        assertEquals(3, Solution().numberOfSpecialChars("aAbBcC"))
    }
}
