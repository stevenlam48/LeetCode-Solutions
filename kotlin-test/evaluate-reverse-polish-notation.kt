package evaluatereversepolishnotation

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class EvaluateReversePolishNotationTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(9, solution.evalRPN(arrayOf("2", "1", "+", "3", "*")))
    }

    @Test
    fun testExample2() {
        assertEquals(6, solution.evalRPN(arrayOf("4", "13", "5", "/", "+")))
    }

    @Test
    fun testExample3() {
        assertEquals(
            22,
            solution.evalRPN(
                arrayOf(
                    "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"
                )
            )
        )
    }

    @Test
    fun testSingleNumber() {
        assertEquals(42, solution.evalRPN(arrayOf("42")))
        assertEquals(-7, solution.evalRPN(arrayOf("-7")))
    }

    @Test
    fun testEmpty() {
        assertEquals(0, solution.evalRPN(arrayOf()))
    }

    @Test
    fun testTruncatingDivision() {
        assertEquals(-3, solution.evalRPN(arrayOf("7", "-2", "/")))
        assertEquals(0, solution.evalRPN(arrayOf("1", "2", "/")))
    }
}
