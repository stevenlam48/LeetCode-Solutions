package lexicographicallysmallestpermutationgreaterthantarget

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LexicographicallySmallestPermutationGreaterThanTargetTest {
    @Test
    fun nextPermutation() {
        assertEquals("bac", Solution().lexGreaterPermutation("abc", "acb"))
    }

    @Test
    fun noGreaterPermutation() {
        assertEquals("", Solution().lexGreaterPermutation("abc", "cba"))
    }

    @Test
    fun duplicateLetters() {
        assertEquals("baa", Solution().lexGreaterPermutation("aab", "aba"))
    }

    @Test
    fun targetItself() {
        assertEquals("aba", Solution().lexGreaterPermutation("aab", "aab"))
    }
}
