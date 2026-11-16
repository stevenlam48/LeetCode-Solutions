package longestrepeatingcharacterreplacement

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestRepeatingCharacterReplacementTest {
    @Test
    fun example1() {
        assertEquals(4, Solution().characterReplacement("ABAB", 2))
    }

    @Test
    fun example2() {
        assertEquals(4, Solution().characterReplacement("AABABBA", 1))
    }

    @Test
    fun singleCharacter() {
        assertEquals(1, Solution().characterReplacement("A", 0))
    }

    @Test
    fun allDistinct() {
        assertEquals(2, Solution().characterReplacement("ABCD", 1))
    }

    @Test
    fun allSame() {
        assertEquals(4, Solution().characterReplacement("AAAA", 0))
    }
}
