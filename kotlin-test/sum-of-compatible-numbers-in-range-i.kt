package sumofcompatiblenumbersinrangei

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SumOfCompatibleNumbersInRangeITest {
    @Test
    fun exampleSmallRange() {
        assertEquals(5, Solution().sumOfGoodIntegers(2, 2))
    }

    @Test
    fun rangeStartingAtOne() {
        assertEquals(6, Solution().sumOfGoodIntegers(1, 3))
    }

    @Test
    fun rangeCrossingHigherBits() {
        assertEquals(44, Solution().sumOfGoodIntegers(8, 8))
        assertEquals(13, Solution().sumOfGoodIntegers(8, 2))
    }

    @Test
    fun noCompatibleNumbers() {
        assertEquals(0, Solution().sumOfGoodIntegers(5, 1))
        assertEquals(0, Solution().sumOfGoodIntegers(6, 0))
    }
}
