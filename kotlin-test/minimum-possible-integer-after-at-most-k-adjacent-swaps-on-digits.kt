package minimumpossibleintegerafteratmostkadjacentswapsondigits

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumPossibleIntegerAfterAtMostKAdjacentSwapsOnDigitsTest {
    private val solution = Solution()

    @Test
    fun limitedSwapsSelectSmallestReachableDigits() {
        assertEquals("1342", solution.minInteger("4321", 4))
    }

    @Test
    fun zeroCanMovePastAvailableDigits() {
        assertEquals("010", solution.minInteger("100", 1))
    }

    @Test
    fun abundantSwapsStillKeepSmallestDigitFirst() {
        assertEquals("36789", solution.minInteger("36789", 1000))
    }

    @Test
    fun zeroSwapsKeepOriginalNumber() {
        assertEquals("321", solution.minInteger("321", 0))
    }

    @Test
    fun exactSwapsCanMoveTwoSmallerDigits() {
        assertEquals("012", solution.minInteger("201", 2))
    }
}
