package longestcommonprefix

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestCommonPrefixTest {
    @Test
    fun commonPrefix() {
        assertEquals("fl", Solution().longestCommonPrefix(arrayOf("flower", "flow", "flight")))
    }

    @Test
    fun noCommonPrefix() {
        assertEquals("", Solution().longestCommonPrefix(arrayOf("dog", "racecar", "car")))
    }

    @Test
    fun singleString() {
        assertEquals("a", Solution().longestCommonPrefix(arrayOf("a")))
        assertEquals("abc", Solution().longestCommonPrefix(arrayOf("abc")))
    }

    @Test
    fun emptyInput() {
        assertEquals("", Solution().longestCommonPrefix(emptyArray()))
    }

    @Test
    fun emptyStringAmongInputs() {
        assertEquals("", Solution().longestCommonPrefix(arrayOf("", "a")))
    }

    @Test
    fun oneStringIsPrefix() {
        assertEquals("ab", Solution().longestCommonPrefix(arrayOf("ab", "ab")))
        assertEquals("a", Solution().longestCommonPrefix(arrayOf("a", "ab")))
    }
}
