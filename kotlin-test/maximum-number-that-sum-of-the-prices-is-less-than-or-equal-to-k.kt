package maximumnumberthatsumofthepricesislessthanorequaltok

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumnumberthatsumofthepricesislessthanorequaltokTest {
    @Test
    fun example1() {
        assertEquals(6L, Solution().findMaximumNumber(9L, 1))
    }

    @Test
    fun example2() {
        assertEquals(9L, Solution().findMaximumNumber(7L, 2))
    }

    @Test
    fun smallestK() {
        assertEquals(1L, Solution().findMaximumNumber(1L, 1))
    }

    @Test
    fun twoPrices() {
        assertEquals(2L, Solution().findMaximumNumber(2L, 1))
    }

    @Test
    fun tenPrices() {
        assertEquals(6L, Solution().findMaximumNumber(10L, 1))
    }
}
