package implementstrstr

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ImplementStrstrTest {
    @Test
    fun example1() {
        assertEquals(0, Solution().strStr("sadbutsad", "sad"))
    }

    @Test
    fun example2() {
        assertEquals(-1, Solution().strStr("leetcode", "leeto"))
    }

    @Test
    fun emptyNeedle() {
        assertEquals(0, Solution().strStr("hello", ""))
        assertEquals(0, Solution().strStr("", ""))
    }

    @Test
    fun singleCharacters() {
        assertEquals(0, Solution().strStr("a", "a"))
        assertEquals(-1, Solution().strStr("a", "b"))
        assertEquals(2, Solution().strStr("abc", "c"))
    }

    @Test
    fun overlappingPattern() {
        assertEquals(4, Solution().strStr("mississippi", "issip"))
        assertEquals(-1, Solution().strStr("aaa", "aaaa"))
        assertEquals(0, Solution().strStr("aaa", "aa"))
    }
}
