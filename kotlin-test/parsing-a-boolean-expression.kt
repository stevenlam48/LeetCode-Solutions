package parsingabooleanexpression

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class ParsingABooleanExpressionTest {
    @Test
    fun testAndOfOrOfFalse() {
        assertFalse(Solution().parseBoolExpr("&(|(f))"))
    }

    @Test
    fun testOrOfThreeFalseAndTrue() {
        assertTrue(Solution().parseBoolExpr("|(f,f,f,t)"))
    }

    @Test
    fun testNotOfAnd() {
        assertTrue(Solution().parseBoolExpr("!(&(f,t))"))
    }

    @Test
    fun testMixedExpression() {
        assertFalse(Solution().parseBoolExpr("|(&(t,f,t),!(t))"))
    }

    @Test
    fun testSingleLiteral() {
        assertTrue(Solution().parseBoolExpr("t"))
        assertFalse(Solution().parseBoolExpr("f"))
    }

    @Test
    fun testNotOfTrue() {
        assertFalse(Solution().parseBoolExpr("!(t)"))
    }
}
