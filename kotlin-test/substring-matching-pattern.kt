package substringmatchingpattern

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SubstringMatchingPatternTest {
    @Test
    fun testExample1() {
        assertTrue(Solution().hasMatch("leetcode", "ee*e"))
    }

    @Test
    fun testExample2() {
        assertFalse(Solution().hasMatch("car", "a*e"))
    }

    @Test
    fun testExample3() {
        assertTrue(Solution().hasMatch("luck", "u*"))
    }

    @Test
    fun testOnlyStar() {
        assertTrue(Solution().hasMatch("abc", "*"))
    }

    @Test
    fun testOrderMatters() {
        assertTrue(Solution().hasMatch("abc", "a*c"))
        assertFalse(Solution().hasMatch("abc", "c*a"))
        assertTrue(Solution().hasMatch("ab", "a*b"))
        assertFalse(Solution().hasMatch("ab", "b*a"))
    }

    @Test
    fun testOverlapNotAllowed() {
        assertFalse(Solution().hasMatch("abc", "ab*bc"))
        assertTrue(Solution().hasMatch("abc", "*c"))
        assertTrue(Solution().hasMatch("abc", "a*"))
    }
}
