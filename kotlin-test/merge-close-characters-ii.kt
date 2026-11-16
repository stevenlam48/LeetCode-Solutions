package mergeclosecharactersii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MergeCloseCharactersIiTest {
    @Test
    fun mergedSubstring() {
        assertEquals("abcab", Solution().mergeCharacters("abacaba", 2))
    }

    @Test
    fun exactDistanceIsSkipped() {
        assertEquals("abc", Solution().mergeCharacters("abca", 3))
        assertEquals("abca", Solution().mergeCharacters("abca", 2))
    }

    @Test
    fun repeatedCharacters() {
        assertEquals("abc", Solution().mergeCharacters("aabbcc", 1))
        assertEquals("ab", Solution().mergeCharacters("ababab", 3))
    }

    @Test
    fun emptyInput() {
        assertEquals("", Solution().mergeCharacters("", 0))
    }
}
