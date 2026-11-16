package checkdivisibilitybydigitsumandproduct

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CheckDivisibilityByDigitSumAndProductTest {
    private val solution = Solution()

    @Test
    fun zeroDigitReducesProduct() {
        assertTrue(solution.checkDivisibility(10))
        assertTrue(solution.checkDivisibility(20))
    }

    @Test
    fun nonzeroDigitsNotDivisible() {
        assertFalse(solution.checkDivisibility(12))
        assertFalse(solution.checkDivisibility(36))
    }

    @Test
    fun singleDigits() {
        assertTrue(solution.checkDivisibility(0))
        assertFalse(solution.checkDivisibility(1))
        assertFalse(solution.checkDivisibility(9))
    }
}
