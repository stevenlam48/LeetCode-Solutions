package totalwavinessofnumbersinrangeii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TotalWavinessOfNumbersInRangeIITest {
    @Test
    fun example() {
        assertEquals(3L, Solution().totalWaviness(120, 130))
    }

    @Test
    fun secondExample() {
        assertEquals(3L, Solution().totalWaviness(198, 202))
    }

    @Test
    fun threeDigitRange() {
        assertEquals(9L, Solution().totalWaviness(100, 110))
    }

    @Test
    fun wavyBoundaries() {
        assertEquals(9L, Solution().totalWaviness(180, 190))
    }

    @Test
    fun fullThreeDigitRange() {
        assertEquals(525L, Solution().totalWaviness(1, 1000))
    }

    @Test
    fun noThreeDigitNumbers() {
        assertEquals(0L, Solution().totalWaviness(1, 10))
    }
}
