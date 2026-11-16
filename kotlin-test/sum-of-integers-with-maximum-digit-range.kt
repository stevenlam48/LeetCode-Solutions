package sumofintegerswithmaximumdigitrange

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SumOfIntegersWithMaximumDigitRangeTest {
    @Test
    fun allSingleDigit() {
        assertEquals(6, Solution().maxDigitRange(intArrayOf(1, 2, 3)))
    }

    @Test
    fun singleTwoDigitCandidate() {
        assertEquals(10, Solution().maxDigitRange(intArrayOf(1, 10)))
    }

    @Test
    fun tieAddsBoth() {
        assertEquals(579, Solution().maxDigitRange(intArrayOf(123, 456)))
    }

    @Test
    fun singleElement() {
        assertEquals(9, Solution().maxDigitRange(intArrayOf(9)))
    }
}
