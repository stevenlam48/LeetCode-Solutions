package totalwavinessofnumbersinrangei

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TotalWavinessOfNumbersInRangeITest {
    @Test
    fun example() {
        assertEquals(3, Solution().totalWaviness(120, 130))
    }

    @Test
    fun secondExample() {
        assertEquals(3, Solution().totalWaviness(198, 202))
    }

    @Test
    fun threeDigitRange() {
        assertEquals(9, Solution().totalWaviness(100, 110))
    }

    @Test
    fun wavyBoundaries() {
        assertEquals(9, Solution().totalWaviness(180, 190))
    }

    @Test
    fun fullThreeDigitRange() {
        assertEquals(525, Solution().totalWaviness(1, 1000))
    }

    @Test
    fun noThreeDigitNumbers() {
        assertEquals(0, Solution().totalWaviness(1, 10))
    }
}
