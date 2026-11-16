package evaluatevalidexpressions

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class EvaluateValidExpressionsTest {
    private val solution = Solution()

    @Test
    fun testBasicOperations() {
        assertEquals(3L, solution.evaluateExpression("add(1,2)"))
        assertEquals(2L, solution.evaluateExpression("sub(5,3)"))
        assertEquals(6L, solution.evaluateExpression("mul(2,3)"))
        assertEquals(3L, solution.evaluateExpression("div(7,2)"))
    }

    @Test
    fun testNested() {
        assertEquals(7L, solution.evaluateExpression("add(1,mul(2,3))"))
        assertEquals(-3L, solution.evaluateExpression("sub(add(1,2),mul(2,3))"))
    }

    @Test
    fun testPlainNumber() {
        assertEquals(42L, solution.evaluateExpression("42"))
        assertEquals(0L, solution.evaluateExpression("0"))
    }

    @Test
    fun testNegativeResult() {
        assertEquals(-5L, solution.evaluateExpression("sub(0,5)"))
        assertEquals(-6L, solution.evaluateExpression("mul(-2,3)"))
    }

    @Test
    fun testLargeValues() {
        assertEquals(1000000000000000000L, solution.evaluateExpression("mul(1000000000,1000000000)"))
    }

    @Test
    fun testDeeplyNested() {
        assertEquals(
            10L,
            solution.evaluateExpression("add(add(add(1,2),3),add(1,3))")
        )
    }
}
