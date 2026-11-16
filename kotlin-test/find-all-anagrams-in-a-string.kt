package findallanagramsinastring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindAllAnagramsInAStringTest {
    @Test
    fun example1() {
        assertEquals(listOf(0, 6), Solution().findAnagrams("cbaebabacd", "abc"))
    }

    @Test
    fun example2() {
        assertEquals(listOf(0, 1, 2), Solution().findAnagrams("abab", "ab"))
    }

    @Test
    fun singleCharacterMatch() {
        assertEquals(listOf(0), Solution().findAnagrams("a", "a"))
    }

    @Test
    fun singleCharacterMismatch() {
        assertEquals(emptyList<Int>(), Solution().findAnagrams("a", "b"))
    }

    @Test
    fun emptySource() {
        assertEquals(emptyList<Int>(), Solution().findAnagrams("", "a"))
    }

    @Test
    fun repeatedPattern() {
        assertEquals(listOf(0), Solution().findAnagrams("aa", "aa"))
    }
}
