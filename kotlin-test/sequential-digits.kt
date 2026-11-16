package sequentialdigits

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class SequentialDigitsTest {
    @Test
    fun exampleHundredToThreeHundred() {
        assertArrayEquals(intArrayOf(123, 234), Solution().sequentialDigits(100, 300))
    }

    @Test
    fun exampleThousandToThirteenThousand() {
        assertArrayEquals(
            intArrayOf(1234, 2345, 3456, 4567, 5678, 6789, 12345),
            Solution().sequentialDigits(1000, 13000),
        )
    }

    @Test
    fun noSequentialNumberInRange() {
        assertArrayEquals(intArrayOf(), Solution().sequentialDigits(10, 10))
    }

    @Test
    fun twoDigitNumbers() {
        assertArrayEquals(
            intArrayOf(12, 23, 34, 45, 56, 67, 78, 89),
            Solution().sequentialDigits(10, 99),
        )
    }

    @Test
    fun partialRange() {
        assertArrayEquals(intArrayOf(67, 78, 89, 123), Solution().sequentialDigits(58, 155))
    }

    @Test
    fun nineDigitSequentialNumber() {
        assertArrayEquals(intArrayOf(123456789), Solution().sequentialDigits(100000000, 1000000000))
    }
}
