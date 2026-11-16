package palindromicsubstrings

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class PalindromicSubstringsTest {
    @Test
    fun testThreeDistinctCharacters() {
        assertEquals(3, Solution().countSubstrings("abc"))
    }

    @Test
    fun testAllSameCharacters() {
        assertEquals(6, Solution().countSubstrings("aaa"))
    }

    @Test
    fun testSingleCharacter() {
        assertEquals(1, Solution().countSubstrings("a"))
    }

    @Test
    fun testEmptyString() {
        assertEquals(0, Solution().countSubstrings(""))
    }

    @Test
    fun testMixedPalindrome() {
        assertEquals(4, Solution().countSubstrings("aba"))
    }

    @Test
    fun testLongPalindrome() {
        assertEquals(12, Solution().countSubstrings("abacaba"))
    }
}
