package countprimegapbalancedsubarrays

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountPrimeGapBalancedSubarraysTest {
    private val solution = Solution()

    @Test
    fun exampleOne() {
        assertEquals(2, solution.primeSubarray(intArrayOf(1, 2, 3), 1))
    }

    @Test
    fun exampleTwo() {
        assertEquals(4, solution.primeSubarray(intArrayOf(2, 3, 5, 7), 3))
    }

    @Test
    fun noPrimes() {
        assertEquals(0, solution.primeSubarray(intArrayOf(4, 6, 8), 2))
    }

    @Test
    fun onlyOnePrime() {
        assertEquals(0, solution.primeSubarray(intArrayOf(1, 2, 4, 8), 10))
    }
}
