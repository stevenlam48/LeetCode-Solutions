package adddigits

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AddDigitsTest {
    private val solution = Solution()

    @Test
    fun twoDigitNumber() {
        assertEquals(2, solution.addDigits(38))
    }

    @Test
    fun zero() {
        assertEquals(0, solution.addDigits(0))
    }

    @Test
    fun singleDigit() {
        assertEquals(7, solution.addDigits(7))
    }

    @Test
    fun multipleOfNine() {
        assertEquals(9, solution.addDigits(9999))
    }
}
