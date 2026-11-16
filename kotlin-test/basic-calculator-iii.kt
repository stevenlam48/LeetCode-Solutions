package basiccalculatoriii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BasicCalculatorIiiTest {
    private val solution = Solution()

    @Test
    fun `evaluates first standard example`() {
        assertEquals(21, solution.calculate("2*(5+5*2)/3+(6/2+8)"))
    }

    @Test
    fun `evaluates second standard example`() {
        assertEquals(-12, solution.calculate("(2+6*3+5-(3*14/7+2)*5)+3"))
    }

    @Test
    fun `evaluates expression without parentheses`() {
        assertEquals(-3, solution.calculate("1+2-4/2*3"))
    }

    @Test
    fun `handles nested parentheses`() {
        assertEquals(7, solution.calculate("((2+3)*4-6)/2"))
    }

    @Test
    fun `returns a multidigit number with surrounding spaces`() {
        assertEquals(12345, solution.calculate(" 12345 "))
    }
}
