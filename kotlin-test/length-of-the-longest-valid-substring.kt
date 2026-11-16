package lengthofthelongestvalidsubstring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LengthOfTheLongestValidSubstringTest {
    @Test
    fun example1() {
        assertEquals(4, Solution().longestValidSubstring("cbaaaabc", listOf("aaa", "cb")))
    }

    @Test
    fun example2() {
        assertEquals(4, Solution().longestValidSubstring("leetcode", listOf("de", "le", "e")))
    }

    @Test
    fun noForbiddenMatch() {
        assertEquals(3, Solution().longestValidSubstring("abc", listOf("d")))
    }

    @Test
    fun wholeWordForbidden() {
        assertEquals(0, Solution().longestValidSubstring("aaa", listOf("a")))
    }

    @Test
    fun emptyForbiddenList() {
        assertEquals(3, Solution().longestValidSubstring("abc", emptyList()))
    }
}
