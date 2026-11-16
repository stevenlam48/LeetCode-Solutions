package maximizesumofsquaresofdigits

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximizeSumOfSquaresOfDigitsTest {
    @Test
    fun example() {
        assertEquals("90", Solution().maxSumOfSquares(2, 9))
    }

    @Test
    fun singleDigit() {
        assertEquals("9", Solution().maxSumOfSquares(1, 9))
    }

    @Test
    fun maximumDigitsSum() {
        assertEquals("99", Solution().maxSumOfSquares(2, 18))
    }

    @Test
    fun remainderPlacedAfterNines() {
        assertEquals("910", Solution().maxSumOfSquares(3, 10))
    }

    @Test
    fun impossible() {
        assertEquals("", Solution().maxSumOfSquares(2, 19))
    }

    @Test
    fun zeroSum() {
        assertEquals("000", Solution().maxSumOfSquares(3, 0))
    }
}
