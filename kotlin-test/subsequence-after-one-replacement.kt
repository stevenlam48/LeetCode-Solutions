package subsequenceafteronereplacement

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SubsequenceAfterOneReplacementTest {
    @Test
    fun testExample1() {
        assertTrue(Solution().canMakeSubsequence("abc", "ahbgdc"))
    }

    @Test
    fun testExample2() {
        assertFalse(Solution().canMakeSubsequence("axc", "ahbgd"))
    }

    @Test
    fun testExactMatch() {
        assertTrue(Solution().canMakeSubsequence("abc", "abc"))
    }

    @Test
    fun testEmptyT() {
        assertFalse(Solution().canMakeSubsequence("a", ""))
    }

    @Test
    fun testOneReplacementNeeded() {
        assertTrue(Solution().canMakeSubsequence("abc", "abxbc"))
        assertTrue(Solution().canMakeSubsequence("abc", "abx"))
    }

    @Test
    fun testTooShort() {
        assertFalse(Solution().canMakeSubsequence("abc", "ab"))
    }
}
