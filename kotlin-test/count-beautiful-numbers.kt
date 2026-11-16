package countbeautifulnumbers

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountBeautifulNumbersTest {
    @Test
    fun singleDigitRange() {
        assertEquals(10, Solution().beautifulNumbers(1, 10))
    }

    @Test
    fun productMustBeDivisibleBySum() {
        assertEquals(1, Solution().beautifulNumbers(10, 12))
        assertEquals(1, Solution().beautifulNumbers(22, 22))
    }

    @Test
    fun notBeautiful() {
        assertEquals(0, Solution().beautifulNumbers(15, 15))
        assertEquals(0, Solution().beautifulNumbers(21, 21))
    }

    @Test
    fun zeroDigitProduct() {
        assertEquals(1, Solution().beautifulNumbers(100, 100))
    }
}
