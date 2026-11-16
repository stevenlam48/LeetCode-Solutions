package isInterleave

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class IsInterleaveTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertTrue(solution.isInterleave("aabcc", "dbbca", "aadbbcbcac"))
    }

    @Test
    fun testExample2() {
        assertFalse(solution.isInterleave("aabcc", "dbbca", "aadbbbaccc"))
    }

    @Test
    fun testAllEmpty() {
        assertTrue(solution.isInterleave("", "", ""))
    }

    @Test
    fun testLengthMismatch() {
        assertFalse(solution.isInterleave("a", "b", "abc"))
    }

    @Test
    fun testOneEmpty() {
        assertTrue(solution.isInterleave("abc", "", "abc"))
        assertTrue(solution.isInterleave("", "abc", "abc"))
    }

    @Test
    fun testOrderMatters() {
        assertTrue(solution.isInterleave("a", "b", "ba"))
        assertFalse(solution.isInterleave("ab", "cd", "badc"))
    }
}
