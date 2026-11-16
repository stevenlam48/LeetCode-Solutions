package filtercharactersbyfrequency

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FilterCharactersByFrequencyTest {
    @Test
    fun example1() {
        assertEquals("", Solution().filterCharacters("abcd", 1))
    }

    @Test
    fun example2() {
        assertEquals("bc", Solution().filterCharacters("aabc", 2))
    }

    @Test
    fun keepsOnlyRareCharacters() {
        assertEquals("cc", Solution().filterCharacters("aaabbbcc", 3))
    }

    @Test
    fun allCharactersKept() {
        assertEquals("abc", Solution().filterCharacters("abc", 2))
    }

    @Test
    fun emptyString() {
        assertEquals("", Solution().filterCharacters("", 1))
    }

    @Test
    fun allCharactersKeptWhenKExceedsFrequency() {
        assertEquals("zzzz", Solution().filterCharacters("zzzz", 5))
    }
}
