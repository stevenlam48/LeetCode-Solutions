package closestprimenumbersinrange

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class ClosestPrimeNumbersInRangeTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertArrayEquals(intArrayOf(11, 13), solution.closestPrimes(10, 19))
    }

    @Test
    fun testExample2() {
        assertArrayEquals(intArrayOf(-1, -1), solution.closestPrimes(4, 6))
    }

    @Test
    fun testTwoConsecutivePrimes() {
        assertArrayEquals(intArrayOf(2, 3), solution.closestPrimes(2, 3))
    }

    @Test
    fun testTiePrefersSmallerPair() {
        assertArrayEquals(intArrayOf(3, 5), solution.closestPrimes(3, 7))
    }

    @Test
    fun testSinglePrimeInRange() {
        assertArrayEquals(intArrayOf(-1, -1), solution.closestPrimes(2, 2))
    }

    @Test
    fun testWiderRange() {
        assertArrayEquals(intArrayOf(19, 23), solution.closestPrimes(19, 23))
    }
}
