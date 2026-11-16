package longestchunkedpalindromedecomposition

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestChunkedPalindromeDecompositionTest {
    @Test
    fun longDecomposition() {
        assertEquals(7, Solution().longestDecomposition("ghiabcdefhelloadamhelloabcdefghi"))
    }

    @Test
    fun singleChunk() {
        assertEquals(1, Solution().longestDecomposition("merchant"))
    }

    @Test
    fun manyChunks() {
        assertEquals(11, Solution().longestDecomposition("antaprezatepzapreanta"))
    }

    @Test
    fun repeatedCharacter() {
        assertEquals(3, Solution().longestDecomposition("aaa"))
        assertEquals(1, Solution().longestDecomposition("a"))
    }

    @Test
    fun twoCharacterPalindrome() {
        assertEquals(2, Solution().longestDecomposition("aa"))
    }
}
