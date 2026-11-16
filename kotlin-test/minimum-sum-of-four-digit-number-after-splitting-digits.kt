package minimumsumoffourdigitnumberaftersplittingdigits

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumSumOfFourDigitNumberAfterSplittingDigitsTest {
    @Test
    fun example1() {
        assertEquals(52, Solution().minimumSum(2932))
    }

    @Test
    fun example2() {
        assertEquals(13, Solution().minimumSum(4009))
    }

    @Test
    fun unsortedDigitsWithZero() {
        assertEquals(22, Solution().minimumSum(3109))
    }

    @Test
    fun repeatedDigits() {
        assertEquals(198, Solution().minimumSum(9999))
    }

    @Test
    fun allSameDigits() {
        assertEquals(44, Solution().minimumSum(2222))
    }
}
