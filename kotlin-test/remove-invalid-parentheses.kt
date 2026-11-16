package removeinvalidparentheses

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RemoveInvalidParenthesesTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(
            setOf("()()()", "(())()"),
            solution.removeInvalidParentheses("()())()").toSet()
        )
    }

    @Test
    fun testExample2() {
        assertEquals(
            setOf("(a)()()", "(a())()"),
            solution.removeInvalidParentheses("(a)())()").toSet()
        )
    }

    @Test
    fun testExample3() {
        assertEquals(setOf(""), solution.removeInvalidParentheses(")(").toSet())
    }

    @Test
    fun testNoParentheses() {
        assertEquals(setOf("n"), solution.removeInvalidParentheses("n").toSet())
    }

    @Test
    fun testValidInput() {
        assertEquals(setOf("()"), solution.removeInvalidParentheses("()").toSet())
    }
}
