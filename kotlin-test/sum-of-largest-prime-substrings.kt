package sumoflargestprimesubstrings

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SumOfLargestPrimeSubstringsTest {
    private val solution = Solution()

    @Test
    fun largestThreePrimes() {
        assertEquals(1469L, solution.sumOfLargestPrimes("12234"))
    }

    @Test
    fun duplicatePrimesAreCountedOnce() {
        assertEquals(11L, solution.sumOfLargestPrimes("111"))
    }

    @Test
    fun fewerThanThreePrimes() {
        assertEquals(31L, solution.sumOfLargestPrimes("235"))
    }

    @Test
    fun leadingZerosDoNotCreateDistinctValues() {
        assertEquals(2L, solution.sumOfLargestPrimes("021"))
    }

    @Test
    fun noPrimeSubstring() {
        assertEquals(0L, solution.sumOfLargestPrimes("0"))
    }
}
