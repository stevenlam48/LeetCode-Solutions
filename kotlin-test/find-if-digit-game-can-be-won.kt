package findifdigitgamecanbewon

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class FindIfDigitGameCanBeWonTest {
    @Test
    fun equalTotals() {
        assertFalse(Solution().canAliceWin(intArrayOf(1, 2, 3, 4, 10)))
    }

    @Test
    fun singleDigitTotalWins() {
        assertTrue(Solution().canAliceWin(intArrayOf(1, 2, 3, 4, 5, 14)))
    }

    @Test
    fun doubleDigitTotalWins() {
        assertTrue(Solution().canAliceWin(intArrayOf(5, 5, 5, 25)))
    }

    @Test
    fun singleElement() {
        assertTrue(Solution().canAliceWin(intArrayOf(7)))
    }
}
