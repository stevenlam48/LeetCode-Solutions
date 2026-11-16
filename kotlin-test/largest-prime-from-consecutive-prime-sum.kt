package largestprimefromconsecutiveprimesum

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LargestPrimeFromConsecutivePrimeSumTest {
    private val solution = Solution()

    @Test
    fun testExample() {
        assertEquals(5, solution.largestPrime(12))
    }

    @Test
    fun testSmallN() {
        assertEquals(2, solution.largestPrime(2))
        assertEquals(0, solution.largestPrime(1))
    }

    @Test
    fun testExactPrefixSum() {
        assertEquals(17, solution.largestPrime(17))
    }

    @Test
    fun testBetweenPrefixSums() {
        assertEquals(5, solution.largestPrime(10))
    }

    @Test
    fun testLargerN() {
        assertEquals(41, solution.largestPrime(100))
    }
}
