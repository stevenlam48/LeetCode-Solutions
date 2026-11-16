package removeoutermostparentheses

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RemoveOutermostParenthesesTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals("()()()", solution.removeOuterParentheses("(()())(())"))
    }

    @Test
    fun testExample2() {
        assertEquals("()()()()(())", solution.removeOuterParentheses("(()())(())(()(()))"))
    }

    @Test
    fun testExample3() {
        assertEquals("", solution.removeOuterParentheses("()()"))
    }

    @Test
    fun testSinglePair() {
        assertEquals("", solution.removeOuterParentheses("()"))
    }

    @Test
    fun testNested() {
        assertEquals("()", solution.removeOuterParentheses("(())"))
    }
}
