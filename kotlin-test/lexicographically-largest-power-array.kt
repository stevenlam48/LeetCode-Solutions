package lexicographicallylargestpowerarray

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class LexicographicallyLargestPowerArrayTest {
    @Test
    fun smallMixedSet() {
        val expected = intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 1)
        assertArrayEquals(expected, Solution().largestPower(intArrayOf(1, 2, 3)))
    }

    @Test
    fun singleThree() {
        val expected = intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1)
        assertArrayEquals(expected, Solution().largestPower(intArrayOf(3)))
    }

    @Test
    fun singleZero() {
        assertArrayEquals(IntArray(15), Solution().largestPower(intArrayOf(0)))
    }

    @Test
    fun singleOne() {
        val expected = intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1)
        assertArrayEquals(expected, Solution().largestPower(intArrayOf(1)))
    }
}
