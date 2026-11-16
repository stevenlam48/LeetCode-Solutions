package maximizenumberofnicedivisors

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximizeNumberOfNiceDivisorsTest {
    @Test
    fun onePrimeFactor() {
        assertEquals(1, Solution().maxNiceDivisors(1))
    }

    @Test
    fun twoPrimeFactors() {
        assertEquals(2, Solution().maxNiceDivisors(2))
    }

    @Test
    fun fivePrimeFactors() {
        assertEquals(6, Solution().maxNiceDivisors(5))
    }

    @Test
    fun eightPrimeFactors() {
        assertEquals(18, Solution().maxNiceDivisors(8))
    }

    @Test
    fun tenPrimeFactors() {
        assertEquals(36, Solution().maxNiceDivisors(10))
    }
}
