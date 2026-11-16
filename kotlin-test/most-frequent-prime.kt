package mostfrequentprime

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MostFrequentPrimeTest {
    private val solution = Solution()

    @Test
    fun findsPrimeGeneratedAlongThreeDirections() {
        assertEquals(19, solution.mostFrequentPrime(arrayOf(intArrayOf(1, 1), intArrayOf(9, 9))))
    }

    @Test
    fun selectsLargestPrimeWhenFrequenciesTie() {
        assertEquals(97, solution.mostFrequentPrime(arrayOf(intArrayOf(1, 9), intArrayOf(3, 7))))
    }

    @Test
    fun returnsMinusOneWhenNoPrimeCanBeFormed() {
        assertEquals(-1, solution.mostFrequentPrime(arrayOf(intArrayOf(2, 4), intArrayOf(6, 8))))
        assertEquals(-1, solution.mostFrequentPrime(arrayOf(intArrayOf(1))))
    }
}
