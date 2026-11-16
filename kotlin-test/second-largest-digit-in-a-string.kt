package secondlargestdigitinastring

// Time:  O(n)
// Space: O(1)

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SecondLargestDigitInAStringTest {
    @Test
    fun exampleWithSecondDigit() {
        assertEquals(2, Solution().secondHighest("dfa12321afd"))
    }

    @Test
    fun repeatedSingleDigit() {
        assertEquals(-1, Solution().secondHighest("abc1111"))
    }

    @Test
    fun noDigits() {
        assertEquals(-1, Solution().secondHighest("abc"))
        assertEquals(-1, Solution().secondHighest(""))
    }

    @Test
    fun zeroCanBeSecondLargest() {
        assertEquals(0, Solution().secondHighest("ck077"))
    }

    @Test
    fun unorderedDigits() {
        assertEquals(3, Solution().secondHighest("sjh392"))
    }
}
