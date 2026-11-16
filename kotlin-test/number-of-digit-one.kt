package numberofdigitone

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfDigitOneTest {
    @Test
    fun zero() {
        assertEquals(0, Solution().countDigitOne(0))
    }

    @Test
    fun example() {
        assertEquals(6, Solution().countDigitOne(13))
    }

    @Test
    fun ten() {
        assertEquals(2, Solution().countDigitOne(10))
    }

    @Test
    fun crossesSecondDecade() {
        assertEquals(12, Solution().countDigitOne(20))
    }

    @Test
    fun countsOnesInTwoDigitPositions() {
        assertEquals(20, Solution().countDigitOne(99))
    }

    @Test
    fun includesOneHundred() {
        assertEquals(21, Solution().countDigitOne(100))
    }
}
