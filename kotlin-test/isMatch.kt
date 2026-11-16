package isMatch

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class IsMatchTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertFalse(solution.isMatch("aa", "a"))
    }

    @Test
    fun testExample2() {
        assertTrue(solution.isMatch("aa", "a*"))
    }

    @Test
    fun testExample3() {
        assertTrue(solution.isMatch("ab", ".*"))
    }

    @Test
    fun testComplexPattern() {
        assertTrue(solution.isMatch("aab", "c*a*b"))
        assertFalse(solution.isMatch("mississippi", "mis*is*p*."))
    }

    @Test
    fun testEmptyStrings() {
        assertTrue(solution.isMatch("", ""))
        assertTrue(solution.isMatch("", "a*"))
        assertTrue(solution.isMatch("", ".*"))
        assertFalse(solution.isMatch("a", ""))
    }

    @Test
    fun testDotAndStar() {
        assertTrue(solution.isMatch("abc", "a.c"))
        assertTrue(solution.isMatch("aaa", "a*a"))
        assertFalse(solution.isMatch("ab", ".*c"))
    }
}
