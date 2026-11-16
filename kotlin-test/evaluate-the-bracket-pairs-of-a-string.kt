package evaluatethebracketpairsofastring

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class EvaluateTheBracketPairsOfAStringTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(
            "bobistwoyearsold",
            solution.evaluate(
                "(name)is(age)yearsold",
                arrayOf(arrayOf("name", "bob"), arrayOf("age", "two"))
            )
        )
    }

    @Test
    fun testExample2() {
        assertEquals(
            "hi?",
            solution.evaluate("hi(name)", arrayOf(arrayOf("a", "b")))
        )
    }

    @Test
    fun testExample3() {
        assertEquals(
            "bbbnice",
            solution.evaluate("(a)(a)(a)nice", arrayOf(arrayOf("a", "b")))
        )
    }

    @Test
    fun testNoBrackets() {
        assertEquals("hello", solution.evaluate("hello", arrayOf()))
    }

    @Test
    fun testUnknownKey() {
        assertEquals("?", solution.evaluate("(a)", arrayOf()))
    }

    @Test
    fun testEmptyValue() {
        assertEquals(
            "xy",
            solution.evaluate("x(a)y", arrayOf(arrayOf("a", "")))
        )
    }
}
