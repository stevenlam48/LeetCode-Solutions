package numberofequalcountsubstrings

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfEqualCountSubstringsTest {
    @Test
    fun testTripleA() {
        assertEquals(1, Solution().equalCountSubstrings("aaabc", 3))
    }

    @Test
    fun testRepeatedPattern() {
        assertEquals(1, Solution().equalCountSubstrings("abcabc", 2))
    }

    @Test
    fun testSingleCharacter() {
        assertEquals(4, Solution().equalCountSubstrings("aaaa", 1))
    }

    @Test
    fun testTwoCharacters() {
        assertEquals(1, Solution().equalCountSubstrings("abab", 2))
    }

    @Test
    fun testLengthOne() {
        assertEquals(1, Solution().equalCountSubstrings("a", 1))
    }
}
