package parselispexpression

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class ParseLispExpressionTest {
    @Test
    fun testNestedLet() {
        assertEquals(14, Solution().evaluate("(let x 2 (mult x (let x 3 y 4 (add x y))))"))
    }

    @Test
    fun testReassignedVariable() {
        assertEquals(2, Solution().evaluate("(let x 3 x 2 x)"))
    }

    @Test
    fun testSequentialAssignments() {
        assertEquals(5, Solution().evaluate("(let x 1 y 2 x (add x y) (add x y))"))
    }

    @Test
    fun testPlainInteger() {
        assertEquals(1, Solution().evaluate("1"))
    }

    @Test
    fun testNestedAddAndMult() {
        assertEquals(14, Solution().evaluate("(mult 2 (add 3 4))"))
    }

    @Test
    fun testNegativeValues() {
        assertEquals(-6, Solution().evaluate("(let x -2 (mult x 3))"))
    }
}
