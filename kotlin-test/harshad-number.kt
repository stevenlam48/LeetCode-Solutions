package harshadnumber

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class HarshadNumberTest {
    private val solution = Solution()

    @Test
    fun harshadWithMultipleDigits() {
        assertEquals(9, solution.sumOfTheDigitsOfHarshadNumber(18))
    }

    @Test
    fun notHarshad() {
        assertEquals(-1, solution.sumOfTheDigitsOfHarshadNumber(23))
    }

    @Test
    fun singleDigit() {
        assertEquals(7, solution.sumOfTheDigitsOfHarshadNumber(7))
    }

    @Test
    fun largerHarshad() {
        assertEquals(1, solution.sumOfTheDigitsOfHarshadNumber(100))
    }
}
