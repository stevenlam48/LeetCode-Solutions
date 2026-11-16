package monotoneincreasingdigits

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MonotoneIncreasingDigitsTest {
    private val solution = Solution()

    @Test
    fun decreasesSingleDigitNumber() {
        assertEquals(9, solution.monotoneIncreasingDigits(10))
    }

    @Test
    fun keepsMonotoneNumberUnchanged() {
        assertEquals(1234, solution.monotoneIncreasingDigits(1234))
    }

    @Test
    fun changesDigitsAfterLeftmostInversion() {
        assertEquals(299, solution.monotoneIncreasingDigits(332))
    }

    @Test
    fun handlesPowerOfTen() {
        assertEquals(999, solution.monotoneIncreasingDigits(1000))
    }

    @Test
    fun handlesZero() {
        assertEquals(0, solution.monotoneIncreasingDigits(0))
    }
}
