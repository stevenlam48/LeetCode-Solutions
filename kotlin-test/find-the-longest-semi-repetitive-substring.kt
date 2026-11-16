package findthelongestsemirepetitivesubstring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheLongestSemiRepetitiveSubstringTest {
    @Test
    fun example() {
        assertEquals(4, Solution().longestSemiRepetitiveSubstring("52233"))
    }

    @Test
    fun multipleRepeatedPairs() {
        assertEquals(2, Solution().longestSemiRepetitiveSubstring("1111"))
    }

    @Test
    fun noAdjacentPair() {
        assertEquals(4, Solution().longestSemiRepetitiveSubstring("5494"))
    }

    @Test
    fun singleCharacter() {
        assertEquals(1, Solution().longestSemiRepetitiveSubstring("1"))
    }

    @Test
    fun emptyString() {
        assertEquals(0, Solution().longestSemiRepetitiveSubstring(""))
    }
}
