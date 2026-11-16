package largest3samedigitnumberinstring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Largest3SameDigitNumberInStringTest {
    @Test
    fun chooseLargestGoodInteger() {
        assertEquals("777", Solution().largestGoodInteger("6777133339"))
    }

    @Test
    fun zeroTripleIsValid() {
        assertEquals("000", Solution().largestGoodInteger("2300019"))
    }

    @Test
    fun noTriple() {
        assertEquals("", Solution().largestGoodInteger("42352338"))
        assertEquals("", Solution().largestGoodInteger(""))
    }

    @Test
    fun longerRun() {
        assertEquals("111", Solution().largestGoodInteger("1111"))
    }
}
