package minimumwindowsubstring

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MinimumWindowSubstringTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals("BANC", solution.minWindow("ADOBECODEBANC", "ABC"))
    }

    @Test
    fun testSingleCharacter() {
        assertEquals("a", solution.minWindow("a", "a"))
    }

    @Test
    fun testImpossible() {
        assertEquals("", solution.minWindow("a", "aa"))
    }

    @Test
    fun testExactMatch() {
        assertEquals("aa", solution.minWindow("aa", "aa"))
    }

    @Test
    fun testSingleTargetChar() {
        assertEquals("b", solution.minWindow("ab", "b"))
    }
}
