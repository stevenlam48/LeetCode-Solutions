package longestfibonaccisubarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestFibonacciSubarrayTest {
    private val solution = Solution()

    @Test
    fun standardExample() {
        assertEquals(6, solution.longestSubarray(intArrayOf(1, 1, 2, 3, 5, 8)))
    }

    @Test
    fun runInMiddle() {
        assertEquals(5, solution.longestSubarray(intArrayOf(10, 2, 3, 5, 8, 13, 0)))
    }

    @Test
    fun noThreeElementFibonacciRun() {
        assertEquals(2, solution.longestSubarray(intArrayOf(1, 2, 4, 8, 16)))
    }

    @Test
    fun zeroesFormFibonacciRun() {
        assertEquals(4, solution.longestSubarray(intArrayOf(0, 0, 0, 0)))
    }

    @Test
    fun negativeValues() {
        assertEquals(5, solution.longestSubarray(intArrayOf(-3, 2, -1, 1, 0, 7)))
    }
}
