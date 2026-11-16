package findtheleastfrequentdigit

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheLeastFrequentDigitTest {
    @Test
    fun example() {
        assertEquals(1, Solution().getLeastFrequentDigit(1553322))
    }

    @Test
    fun tiesUseSmallestDigit() {
        assertEquals(1, Solution().getLeastFrequentDigit(112233))
    }

    @Test
    fun uniqueDigitWins() {
        assertEquals(4, Solution().getLeastFrequentDigit(1112223334))
    }

    @Test
    fun zeroCanWin() {
        assertEquals(0, Solution().getLeastFrequentDigit(110022))
    }

    @Test
    fun singleDigit() {
        assertEquals(5, Solution().getLeastFrequentDigit(5))
    }
}
