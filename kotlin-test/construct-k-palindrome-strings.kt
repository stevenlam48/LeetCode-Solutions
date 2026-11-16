package constructkpalindromestrings

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ConstructKPalindromeStringsTest {
    @Test
    fun testExample1() {
        assertTrue(Solution().canConstruct("annabelle", 2))
    }

    @Test
    fun testExample2() {
        assertFalse(Solution().canConstruct("leetcode", 3))
    }

    @Test
    fun testExample3() {
        assertTrue(Solution().canConstruct("true", 4))
    }

    @Test
    fun testKGreaterThanLength() {
        assertFalse(Solution().canConstruct("cr", 7))
    }

    @Test
    fun testSingleCharacter() {
        assertTrue(Solution().canConstruct("a", 1))
    }

    @Test
    fun testAllSameCharacter() {
        assertTrue(Solution().canConstruct("aaaa", 2))
        assertFalse(Solution().canConstruct("aaaa", 5))
    }
}
