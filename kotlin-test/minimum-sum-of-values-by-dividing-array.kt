package minimumsumofvaluesbydividingarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumSumOfValuesByDividingArrayTest {
    @Test
    fun example1() {
        assertEquals(
            12,
            Solution().minimumValueSum(intArrayOf(1, 4, 3, 3, 2), intArrayOf(0, 3, 3, 2))
        )
    }

    @Test
    fun example2() {
        assertEquals(
            17,
            Solution().minimumValueSum(intArrayOf(2, 3, 5, 7, 7, 7, 5), intArrayOf(0, 7, 5))
        )
    }

    @Test
    fun example3Impossible() {
        assertEquals(-1, Solution().minimumValueSum(intArrayOf(1, 2, 3, 4), intArrayOf(2)))
    }

    @Test
    fun singleMatchingElement() {
        assertEquals(1, Solution().minimumValueSum(intArrayOf(1), intArrayOf(1)))
    }

    @Test
    fun combinesFinalSegment() {
        assertEquals(6, Solution().minimumValueSum(intArrayOf(2, 6, 4), intArrayOf(2, 4)))
    }
}
