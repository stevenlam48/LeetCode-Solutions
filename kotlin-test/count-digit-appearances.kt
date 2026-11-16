package countdigitappearances

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountDigitAppearancesTest {
    @Test
    fun example() {
        assertEquals(4, Solution().countDigitOccurrences(intArrayOf(12, 13, 14, 15), 1))
    }

    @Test
    fun zeroDigit() {
        assertEquals(2, Solution().countDigitOccurrences(intArrayOf(10, 20, 0), 0))
    }

    @Test
    fun zeroContributesNothing() {
        assertEquals(0, Solution().countDigitOccurrences(intArrayOf(0), 0))
    }

    @Test
    fun repeatedDigits() {
        assertEquals(6, Solution().countDigitOccurrences(intArrayOf(111, 11, 1), 1))
    }

    @Test
    fun emptyArray() {
        assertEquals(0, Solution().countDigitOccurrences(intArrayOf(), 5))
    }
}
