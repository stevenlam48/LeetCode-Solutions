package minimizeresultbyaddingparenthesestoexpression

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimizeResultByAddingParenthesesToExpressionTest {
    @Test
    fun firstExample() {
        assertEquals("2(47+38)", Solution().minimizeResult("247+38"))
    }

    @Test
    fun secondExample() {
        assertEquals("1(2+3)4", Solution().minimizeResult("12+34"))
    }

    @Test
    fun wholeExpressionIsBest() {
        assertEquals("(999+999)", Solution().minimizeResult("999+999"))
    }

    @Test
    fun zeroInsideParentheses() {
        assertEquals("1(05+5)", Solution().minimizeResult("105+5"))
    }

    @Test
    fun smallestOperands() {
        assertEquals("(1+1)", Solution().minimizeResult("1+1"))
    }
}
