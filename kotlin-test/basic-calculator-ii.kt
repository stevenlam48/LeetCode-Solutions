package basiccalculatorii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BasicCalculatorIiTest {
    private val solution = Solution()

    @Test
    fun `multiplication has higher precedence`() {
        assertEquals(7, solution.calculate("3+2*2"))
    }

    @Test
    fun `division truncates toward zero`() {
        assertEquals(1, solution.calculate(" 3/2 "))
    }

    @Test
    fun `handles spaces and multidigit operands`() {
        assertEquals(5, solution.calculate(" 3+5 / 2 "))
    }

    @Test
    fun `applies equal precedence from left to right`() {
        assertEquals(12, solution.calculate("14-3/2*2"))
    }

    @Test
    fun `evaluates parentheses supported by the primary solution`() {
        assertEquals(9, solution.calculate("2*(3+1)+1"))
    }
}
