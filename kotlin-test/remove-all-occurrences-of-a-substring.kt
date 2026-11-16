package removealloccurrencesofasubstring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RemoveAllOccurrencesOfASubstringTest {
    @Test
    fun standardExample() {
        assertEquals("dab", Solution().removeOccurrences("daabcbaabcbc", "abc"))
    }

    @Test
    fun repeatedAndOverlappingRemovals() {
        assertEquals("ab", Solution().removeOccurrences("axxxxyyyyb", "xy"))
    }

    @Test
    fun singleCharacterPart() {
        assertEquals("", Solution().removeOccurrences("aaaa", "a"))
    }

    @Test
    fun noOccurrences() {
        assertEquals("abcdef", Solution().removeOccurrences("abcdef", "xyz"))
    }

    @Test
    fun removalExposesEarlierMatch() {
        assertEquals("ac", Solution().removeOccurrences("aababc", "ab"))
    }
}
