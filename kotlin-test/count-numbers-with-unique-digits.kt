package countnumberswithuniquedigits

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountNumbersWithUniqueDigitsTest {
    private val solution = Solution()

    @Test
    fun zeroDigitsOnlyCountsZero() {
        assertEquals(1, solution.countNumbersWithUniqueDigits(0))
    }

    @Test
    fun oneDigitCountsZeroThroughNine() {
        assertEquals(10, solution.countNumbersWithUniqueDigits(1))
    }

    @Test
    fun twoDigitExample() {
        assertEquals(91, solution.countNumbersWithUniqueDigits(2))
    }

    @Test
    fun threeDigitCount() {
        assertEquals(739, solution.countNumbersWithUniqueDigits(3))
    }

    @Test
    fun maximumUniqueDigitLength() {
        assertEquals(2345851, solution.countNumbersWithUniqueDigits(8))
    }
}
