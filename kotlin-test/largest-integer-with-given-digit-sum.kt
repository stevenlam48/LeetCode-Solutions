package largestintegerwithgivendigitsum

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LargestIntegerWithGivenDigitSumTest {
    @Test
    fun digitsFillFromMostSignificant() {
        assertEquals(90, Solution().largestInteger(2, 9))
        assertEquals(99, Solution().largestInteger(2, 18))
    }

    @Test
    fun sumTooLarge() {
        assertEquals(-1, Solution().largestInteger(2, 19))
    }

    @Test
    fun remainingDigitsBecomeZero() {
        assertEquals(200, Solution().largestInteger(3, 2))
    }

    @Test
    fun zeroLength() {
        assertEquals(0, Solution().largestInteger(0, 0))
        assertEquals(-1, Solution().largestInteger(0, 1))
    }
}
