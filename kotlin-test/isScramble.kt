package isScramble

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class IsScrambleTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertTrue(solution.isScramble("great", "rgeat"))
    }

    @Test
    fun testExample2() {
        assertFalse(solution.isScramble("abcde", "caebd"))
    }

    @Test
    fun testSingleChar() {
        assertTrue(solution.isScramble("a", "a"))
    }

    @Test
    fun testDifferentLengths() {
        assertFalse(solution.isScramble("ab", "abc"))
    }

    @Test
    fun testTwoChars() {
        assertTrue(solution.isScramble("ab", "ba"))
    }

    @Test
    fun testThreeChars() {
        assertTrue(solution.isScramble("abc", "bca"))
        assertTrue(solution.isScramble("abc", "cab"))
        assertTrue(solution.isScramble("abc", "acb"))
        assertFalse(solution.isScramble("ab", "aa"))
    }
}
