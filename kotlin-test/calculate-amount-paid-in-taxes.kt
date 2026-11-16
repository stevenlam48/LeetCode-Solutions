package calculateamountpaidintaxes

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CalculateAmountPaidInTaxesTest {
    @Test
    fun leetCodeExample() {
        val brackets = arrayOf(intArrayOf(3, 50), intArrayOf(7, 10), intArrayOf(12, 25))
        assertEquals(2.65, Solution().calculateTax(brackets, 10), 1e-9)
    }

    @Test
    fun zeroIncome() {
        val brackets = arrayOf(intArrayOf(3, 50), intArrayOf(7, 10))
        assertEquals(0.0, Solution().calculateTax(brackets, 0), 1e-9)
    }

    @Test
    fun incomeAboveAllBrackets() {
        val brackets = arrayOf(intArrayOf(1, 10), intArrayOf(5, 20), intArrayOf(10, 30))
        assertEquals(2.4, Solution().calculateTax(brackets, 20), 1e-9)
    }

    @Test
    fun noBrackets() {
        assertEquals(0.0, Solution().calculateTax(arrayOf(), 100), 1e-9)
    }
}
