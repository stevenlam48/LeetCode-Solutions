package largestmergeoftwostrings

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LargestMergeOfTwoStringsTest {
    @Test
    fun exampleWords() {
        assertEquals("cbcabaaaaa", Solution().largestMerge("cabaa", "bcaaa"))
    }

    @Test
    fun oneWordAlwaysLarger() {
        assertEquals("defabc", Solution().largestMerge("abc", "def"))
    }

    @Test
    fun identicalAndEmptyWords() {
        assertEquals("aaaa", Solution().largestMerge("aa", "aa"))
        assertEquals("abc", Solution().largestMerge("", "abc"))
        assertEquals("", Solution().largestMerge("", ""))
    }

    @Test
    fun prefixRequiresLookingAhead() {
        assertEquals("abaaaaa", Solution().largestMerge("aaa", "abaa"))
    }
}
