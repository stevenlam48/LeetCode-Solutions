package rearrangeksubstringstoformtargetstring

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RearrangeKSubstringsToFormTargetStringTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertTrue(solution.isPossibleToRearrange("abcd", "cdab", 2))
    }

    @Test
    fun testExample2() {
        assertTrue(solution.isPossibleToRearrange("aabbcc", "bbaacc", 3))
    }

    @Test
    fun testExample3() {
        assertFalse(solution.isPossibleToRearrange("aabbcc", "bbaacc", 2))
    }

    @Test
    fun testSingleCharacterPieces() {
        assertTrue(solution.isPossibleToRearrange("abc", "bca", 3))
        assertFalse(solution.isPossibleToRearrange("abc", "abd", 3))
    }

    @Test
    fun testWholeString() {
        assertTrue(solution.isPossibleToRearrange("abc", "abc", 1))
        assertFalse(solution.isPossibleToRearrange("abc", "acb", 1))
    }

    @Test
    fun testRepeatedPieces() {
        assertFalse(solution.isPossibleToRearrange("abab", "baba", 2))
        assertTrue(solution.isPossibleToRearrange("aaaa", "aaaa", 2))
    }
}
