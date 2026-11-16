package longestnicesubarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestNiceSubarrayTest {
    @Test
    fun example1() {
        assertEquals(3, Solution().longestNiceSubarray(intArrayOf(1, 3, 8, 48, 10)))
    }

    @Test
    fun example2() {
        assertEquals(1, Solution().longestNiceSubarray(intArrayOf(3, 1, 5, 11, 13)))
    }

    @Test
    fun allPowersOfTwo() {
        assertEquals(4, Solution().longestNiceSubarray(intArrayOf(1, 2, 4, 8)))
    }

    @Test
    fun pairOnly() {
        assertEquals(2, Solution().longestNiceSubarray(intArrayOf(1, 2, 3)))
    }

    @Test
    fun singleElement() {
        assertEquals(1, Solution().longestNiceSubarray(intArrayOf(5)))
    }
}
