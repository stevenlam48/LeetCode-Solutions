package kthsmallestprimefraction

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class KthSmallestPrimeFractionTest {
    private val solution = Solution()

    @Test
    fun example1() {
        assertArrayEquals(intArrayOf(2, 5), solution.kthSmallestPrimeFraction(intArrayOf(1, 2, 3, 5), 3))
    }

    @Test
    fun twoElements() {
        assertArrayEquals(intArrayOf(1, 7), solution.kthSmallestPrimeFraction(intArrayOf(1, 7), 1))
    }

    @Test
    fun smallestFraction() {
        assertArrayEquals(intArrayOf(1, 5), solution.kthSmallestPrimeFraction(intArrayOf(1, 2, 3, 5), 1))
    }

    @Test
    fun middleFraction() {
        assertArrayEquals(intArrayOf(1, 2), solution.kthSmallestPrimeFraction(intArrayOf(1, 2, 3, 5), 4))
    }

    @Test
    fun largestFraction() {
        assertArrayEquals(intArrayOf(2, 3), solution.kthSmallestPrimeFraction(intArrayOf(1, 2, 3, 5), 6))
    }

    @Test
    fun twoElementPair() {
        assertArrayEquals(intArrayOf(1, 2), solution.kthSmallestPrimeFraction(intArrayOf(1, 2), 1))
    }
}
