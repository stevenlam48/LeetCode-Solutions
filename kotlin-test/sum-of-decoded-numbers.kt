package sumofdecodednumbers

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SumOfDecodedNumbersTest {
    @Test
    fun fourDigitValues() {
        assertEquals(8388608, Solution().sumDecoded(longArrayOf(2231)))
        assertEquals(143178169, Solution().sumDecoded(longArrayOf(3231)))
    }

    @Test
    fun summedValues() {
        assertEquals(151566777, Solution().sumDecoded(longArrayOf(2231, 3231)))
    }

    @Test
    fun zeroExponent() {
        assertEquals(1, Solution().sumDecoded(longArrayOf(111)))
    }
}
