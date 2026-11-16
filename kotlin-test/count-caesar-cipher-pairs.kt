package countcaesarcipherpairs

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountCaesarCipherPairsTest {
    @Test
    fun shiftedWords() {
        assertEquals(3L, Solution().countPairs(listOf("abc", "bcd", "xyz")))
        assertEquals(1L, Solution().countPairs(listOf("abc", "def", "ace")))
    }

    @Test
    fun repeatedWords() {
        assertEquals(3L, Solution().countPairs(listOf("aa", "aa", "aa")))
    }

    @Test
    fun singleCharacters() {
        assertEquals(1L, Solution().countPairs(listOf("a", "z", "aa", "ba")))
    }

    @Test
    fun noWords() {
        assertEquals(0L, Solution().countPairs(emptyList()))
    }
}
