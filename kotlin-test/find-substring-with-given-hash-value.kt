package findsubstringwithgivenhashvalue

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindSubstringWithGivenHashValueTest {
    @Test
    fun testExample1() {
        assertEquals("ee", Solution().subStrHash("leetcode", 7, 20, 2, 0))
    }

    @Test
    fun testSecondSubstring() {
        assertEquals("bc", Solution().subStrHash("abc", 2, 100, 2, 2 + 3 * 2))
    }

    @Test
    fun testFirstSubstring() {
        assertEquals("ab", Solution().subStrHash("abc", 2, 100, 2, 1 + 2 * 2))
    }

    @Test
    fun testSingleCharacter() {
        assertEquals("x", Solution().subStrHash("x", 1, 1, 1, 0))
    }

    @Test
    fun testWholeString() {
        assertEquals("abc", Solution().subStrHash("abc", 3, 1000, 3, 1 + 2 * 3 + 3 * 9))
    }
}
