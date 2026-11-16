package lengthofthelongestalphabeticalcontinuoussubstring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LengthOfTheLongestAlphabeticalContinuousSubstringTest {
    @Test
    fun example1() {
        assertEquals(2, Solution().longestContinuousSubstring("abacaba"))
    }

    @Test
    fun example2() {
        assertEquals(5, Solution().longestContinuousSubstring("abcde"))
    }

    @Test
    fun singleCharacter() {
        assertEquals(1, Solution().longestContinuousSubstring("a"))
    }

    @Test
    fun duplicates() {
        assertEquals(1, Solution().longestContinuousSubstring("aa"))
    }

    @Test
    fun prefixThenBreak() {
        assertEquals(3, Solution().longestContinuousSubstring("abcab"))
    }
}
