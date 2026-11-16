package primesubsetselectionii

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class PrimeSubsetSelectionIITest {
    @Test
    fun allPrimesFit() {
        assertArrayEquals(intArrayOf(2, 3, 5), Solution().maxPrimeSubset(5, 10))
    }

    @Test
    fun exactBudget() {
        assertArrayEquals(intArrayOf(3, 7), Solution().maxPrimeSubset(10, 10))
    }

    @Test
    fun maxSumTieBreak() {
        assertArrayEquals(intArrayOf(11, 19), Solution().maxPrimeSubset(20, 30))
    }

    @Test
    fun largerBudget() {
        assertArrayEquals(intArrayOf(2, 3, 5, 7), Solution().maxPrimeSubset(10, 20))
    }

    @Test
    fun singlePrime() {
        assertArrayEquals(intArrayOf(2), Solution().maxPrimeSubset(3, 2))
    }

    @Test
    fun emptySubset() {
        assertArrayEquals(intArrayOf(), Solution().maxPrimeSubset(2, 1))
    }

    @Test
    fun noPrimes() {
        assertArrayEquals(intArrayOf(), Solution().maxPrimeSubset(1, 5))
    }
}
