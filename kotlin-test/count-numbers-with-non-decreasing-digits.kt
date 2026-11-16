package countnumberswithnondecreasingdigits

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountNumbersWithNonDecreasingDigitsTest {
    private val solution = Solution()

    @Test
    fun binaryRange() {
        assertEquals(3, solution.countNumbers("1", "10", 2))
    }

    @Test
    fun octalLeetCodeExample() {
        assertEquals(3, solution.countNumbers("23", "28", 8))
    }

    @Test
    fun decimalSingleAndDoubleDigits() {
        assertEquals(18, solution.countNumbers("1", "20", 10))
    }

    @Test
    fun decimalThreeDigitRange() {
        assertEquals(45, solution.countNumbers("100", "200", 10))
    }

    @Test
    fun sameInclusiveEndpoint() {
        assertEquals(1, solution.countNumbers("123", "123", 10))
        assertEquals(0, solution.countNumbers("132", "132", 10))
    }
}
