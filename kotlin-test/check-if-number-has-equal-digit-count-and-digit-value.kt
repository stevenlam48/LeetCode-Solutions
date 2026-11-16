package checkifnumberhasequaldigitcountanddigitvalue

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CheckIfNumberHasEqualDigitCountAndDigitValueTest {
    private val solution = Solution()

    @Test
    fun validFourDigitNumber() {
        assertTrue(solution.digitCount("1210"))
    }

    @Test
    fun invalidThreeDigitNumber() {
        assertFalse(solution.digitCount("030"))
    }

    @Test
    fun noSingleDigitMatches() {
        assertFalse(solution.digitCount("1"))
    }

    @Test
    fun validTenDigitNumber() {
        assertTrue(solution.digitCount("6210001000"))
    }
}
