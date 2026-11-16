package maximumswap

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumSwapTest {
    private val solution = Solution()

    @Test
    fun standardExample() {
        assertEquals(7236, solution.maximumSwap(2736))
    }

    @Test
    fun alreadyMaximum() {
        assertEquals(9973, solution.maximumSwap(9973))
    }

    @Test
    fun swapWithLaterDigit() {
        assertEquals(9913, solution.maximumSwap(1993))
    }

    @Test
    fun largerExample() {
        assertEquals(98863, solution.maximumSwap(98368))
    }

    @Test
    fun ascendingDigits() {
        assertEquals(4231, solution.maximumSwap(1234))
    }

    @Test
    fun trailingZero() {
        assertEquals(10, solution.maximumSwap(10))
    }
}
