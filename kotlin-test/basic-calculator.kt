package basiccalculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BasicCalculatorTest {
    private val solution = Solution()

    @Test
    fun `adds numbers with spaces`() {
        assertEquals(2, solution.calculate("1 + 1"))
    }

    @Test
    fun `evaluates addition and subtraction left to right`() {
        assertEquals(3, solution.calculate(" 2-1 + 2 "))
    }

    @Test
    fun `evaluates nested parentheses`() {
        assertEquals(23, solution.calculate("(1+(4+5+2)-3)+(6+8)"))
    }

    @Test
    fun `respects multiplication and division precedence`() {
        assertEquals(11, solution.calculate("2+3*4-10/3"))
    }

    @Test
    fun `combines parentheses with all operators`() {
        assertEquals(15, solution.calculate("(2+6*3)-(8/2+1)"))
    }
}
