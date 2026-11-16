package countgoodintegersinarange

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountGoodIntegersInARangeTest {
    private val solution = Solution()

    @Test
    fun countsSingleDigitIntegersAndTen() {
        assertEquals(10L, solution.goodIntegers(1, 10, 1))
    }

    @Test
    fun excludesLargeAdjacentDigitJumps() {
        assertEquals(12L, solution.goodIntegers(1, 20, 1))
    }

    @Test
    fun supportsRepeatedDigitsOnly() {
        assertEquals(2L, solution.goodIntegers(10, 30, 0))
    }

    @Test
    fun includesZeroAtLowerBoundary() {
        assertEquals(1L, solution.goodIntegers(0, 0, 1))
    }
}
