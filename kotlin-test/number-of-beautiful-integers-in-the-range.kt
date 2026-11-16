package numberofbeautifulintegersintherange

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfBeautifulIntegersInTheRangeTest {
    @Test
    fun oneToTenKOne() {
        assertEquals(1, Solution().numberOfBeautifulIntegers(1, 10, 1))
    }

    @Test
    fun oneToTwentyKTwo() {
        assertEquals(5, Solution().numberOfBeautifulIntegers(1, 20, 2))
    }

    @Test
    fun oneToHundredKThree() {
        assertEquals(16, Solution().numberOfBeautifulIntegers(1, 100, 3))
    }

    @Test
    fun singleNonBeautifulNumber() {
        assertEquals(0, Solution().numberOfBeautifulIntegers(10, 10, 3))
    }

    @Test
    fun singleDigitRange() {
        assertEquals(0, Solution().numberOfBeautifulIntegers(5, 5, 2))
    }

    @Test
    fun oneToThousandKSeven() {
        assertEquals(7, Solution().numberOfBeautifulIntegers(1, 1000, 7))
    }
}
