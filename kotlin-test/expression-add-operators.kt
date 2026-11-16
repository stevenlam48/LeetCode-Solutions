package expressionaddoperators

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ExpressionAddOperatorsTest {
    private val solution = Solution()

    @Test
    fun `finds addition and multiplication expressions`() {
        assertEquals(listOf("1+2+3", "1*2*3"), solution.addOperators("123", 6))
    }

    @Test
    fun `preserves depth first result order`() {
        assertEquals(listOf("2+3*2", "2*3+2"), solution.addOperators("232", 8))
    }

    @Test
    fun `rejects operands with leading zeroes`() {
        assertEquals(listOf("1*0+5", "10-5"), solution.addOperators("105", 5))
    }

    @Test
    fun `supports zero as every operand`() {
        assertEquals(listOf("0+0", "0-0", "0*0"), solution.addOperators("00", 0))
    }

    @Test
    fun `handles a single digit number`() {
        assertEquals(listOf("5"), solution.addOperators("5", 5))
        assertEquals(emptyList<String>(), solution.addOperators("5", 4))
    }
}
