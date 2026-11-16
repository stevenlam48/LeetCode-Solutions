package goatlatin

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GoatLatinTest {
    @Test
    fun `standard example`() {
        assertEquals("Imaa peaksmaaa oatGmaaaa atinLmaaaaa", Solution().toGoatLatin("I speak Goat Latin"))
    }

    @Test
    fun `vowel and consonant words`() {
        val solution = Solution()
        assertEquals("applemaa", solution.toGoatLatin("apple"))
        assertEquals("oatgmaa", solution.toGoatLatin("goat"))
        assertEquals("elloHmaa orldwmaaa", solution.toGoatLatin("Hello world"))
    }

    @Test
    fun `suffix length follows word position`() {
        assertEquals("Amaa bBmaaa cCmaaaa", Solution().toGoatLatin("A Bb Cc"))
    }
}
