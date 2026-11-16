package ternaryexpressionparser

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TernaryExpressionParserTest {
    @Test
    fun standardExamples() {
        assertEquals("2", Solution().parseTernary("T?2:3"))
        assertEquals("4", Solution().parseTernary("F?1:T?4:5"))
        assertEquals("F", Solution().parseTernary("T?T?F:5:3"))
    }

    @Test
    fun singleValue() {
        assertEquals("7", Solution().parseTernary("7"))
    }

    @Test
    fun emptyExpression() {
        assertEquals("", Solution().parseTernary(""))
    }
}
