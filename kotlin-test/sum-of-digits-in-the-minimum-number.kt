package sumofdigitsintheminimumnumber

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SumOfDigitsInTheMinimumNumberTest {
    @Test
    fun minimumIsOne() {
        assertEquals(0, Solution().sumOfDigits(intArrayOf(34, 23, 1, 24, 75, 33, 54, 8)))
    }

    @Test
    fun minimumHasEvenDigitSum() {
        assertEquals(1, Solution().sumOfDigits(intArrayOf(99, 77, 33, 66, 55)))
    }

    @Test
    fun singleElement() {
        assertEquals(1, Solution().sumOfDigits(intArrayOf(11)))
        assertEquals(0, Solution().sumOfDigits(intArrayOf(10)))
    }
}
