package nthdigit

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NthDigitTest {
    @Test
    fun example1() {
        assertEquals(3, Solution().findNthDigit(3))
    }

    @Test
    fun example2() {
        assertEquals(0, Solution().findNthDigit(11))
    }

    @Test
    fun firstDigit() {
        assertEquals(1, Solution().findNthDigit(1))
    }

    @Test
    fun lastSingleDigit() {
        assertEquals(9, Solution().findNthDigit(9))
    }

    @Test
    fun startOfTwoDigitNumbers() {
        assertEquals(1, Solution().findNthDigit(10))
    }

    @Test
    fun secondDigitOfEleven() {
        assertEquals(1, Solution().findNthDigit(12))
    }
}
