package longestvalidparentheses

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LongestValidParenthesesTest {
    private val solution = Solution()

    @Test
    fun testExampleOne() {
        assertEquals(2, solution.longestValidParentheses("(()"))
    }

    @Test
    fun testExampleTwo() {
        assertEquals(4, solution.longestValidParentheses(")()())"))
    }

    @Test
    fun testEmptyString() {
        assertEquals(0, solution.longestValidParentheses(""))
    }

    @Test
    fun testAllOpen() {
        assertEquals(0, solution.longestValidParentheses("(((("))
    }

    @Test
    fun testAllClosed() {
        assertEquals(0, solution.longestValidParentheses("))))"))
    }

    @Test
    fun testNestedPairs() {
        assertEquals(6, solution.longestValidParentheses("()(())"))
    }
}
