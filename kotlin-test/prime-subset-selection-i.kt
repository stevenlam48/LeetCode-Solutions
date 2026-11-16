package primesubsetselectioni

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class PrimeSubsetSelectionITest {
    @Test
    fun allPrimesFit() {
        assertArrayEquals(intArrayOf(2, 3, 5, 7), Solution().maxPrimes(10, 20))
    }

    @Test
    fun budgetCutsOff() {
        assertArrayEquals(intArrayOf(2, 3, 5), Solution().maxPrimes(10, 10))
    }

    @Test
    fun singlePrime() {
        assertArrayEquals(intArrayOf(2), Solution().maxPrimes(5, 2))
    }

    @Test
    fun noPrimeBelowN() {
        assertArrayEquals(intArrayOf(), Solution().maxPrimes(1, 100))
    }

    @Test
    fun budgetTooSmall() {
        assertArrayEquals(intArrayOf(), Solution().maxPrimes(2, 1))
    }
}
