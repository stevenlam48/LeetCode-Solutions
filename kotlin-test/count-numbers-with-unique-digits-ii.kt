package countnumberswithuniquedigitsii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountNumbersWithUniqueDigitsIiTest {
    private val solution = Solution()

    @Test
    fun fullExampleRange() {
        assertEquals(19, solution.numberCount(1, 20))
    }

    @Test
    fun excludesRepeatedDigits() {
        assertEquals(10, solution.numberCount(9, 19))
    }

    @Test
    fun crossesThreeDigitBoundary() {
        assertEquals(27, solution.numberCount(80, 120))
    }

    @Test
    fun zeroIsAUniqueDigitNumber() {
        assertEquals(1, solution.numberCount(0, 0))
    }

    @Test
    fun repeatedDigitSingletonRangeIsExcluded() {
        assertEquals(0, solution.numberCount(11, 11))
        assertEquals(1, solution.numberCount(12, 12))
    }
}
