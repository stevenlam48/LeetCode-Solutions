package issubsequence

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class IsSubsequenceTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertTrue(solution.isSubsequence("abc", "ahbgdc"))
    }

    @Test
    fun testExample2() {
        assertFalse(solution.isSubsequence("axc", "ahbgdc"))
    }

    @Test
    fun testEmptyS() {
        assertTrue(solution.isSubsequence("", "ahbgdc"))
        assertTrue(solution.isSubsequence("", ""))
    }

    @Test
    fun testEmptyT() {
        assertFalse(solution.isSubsequence("a", ""))
    }

    @Test
    fun testEqualStrings() {
        assertTrue(solution.isSubsequence("abc", "abc"))
    }

    @Test
    fun testOrderMatters() {
        assertFalse(solution.isSubsequence("aec", "abcde"))
    }
}
