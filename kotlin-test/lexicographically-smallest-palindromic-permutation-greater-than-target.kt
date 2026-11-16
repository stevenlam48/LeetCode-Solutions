package lexicographicallysmallestpalindromicpermutationgreaterthantarget

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LexicographicallySmallestPalindromicPermutationGreaterThanTargetTest {
    @Test
    fun nextPalindrome() {
        assertEquals("abba", Solution().lexPalindromicPermutation("aabb", "abab"))
    }

    @Test
    fun noGreaterPalindrome() {
        assertEquals("", Solution().lexPalindromicPermutation("aabb", "bbaa"))
    }

    @Test
    fun impossiblePalindrome() {
        assertEquals("", Solution().lexPalindromicPermutation("abc", "abc"))
    }

    @Test
    fun targetBelowAllPalindromes() {
        assertEquals("abba", Solution().lexPalindromicPermutation("aabb", "aaaa"))
    }
}
