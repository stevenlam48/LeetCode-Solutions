package minimumwindowsubsequence

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MinimumWindowSubsequenceTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals("bcde", solution.minWindow("abcdebdde", "bde"))
    }

    @Test
    fun testNoMatch() {
        assertEquals("", solution.minWindow("jmeqksfrsdcmsiwvaovztaqenprpvnbstl", "u"))
    }

    @Test
    fun testRepeatedCharacters() {
        assertEquals("aa", solution.minWindow("aaaa", "aa"))
    }

    @Test
    fun testTargetLongerThanSource() {
        assertEquals("", solution.minWindow("abc", "abcd"))
    }

    @Test
    fun testExactMatch() {
        assertEquals("abc", solution.minWindow("abc", "abc"))
    }
}
