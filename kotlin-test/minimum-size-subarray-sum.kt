package minimumsizesubarraysum

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MinimumSizeSubarraySumTest {
    @Test
    fun example1() {
        assertEquals(2, Solution().minSubArrayLen(7, intArrayOf(2, 3, 1, 2, 4, 3)))
    }

    @Test
    fun example2() {
        assertEquals(1, Solution().minSubArrayLen(4, intArrayOf(1, 4, 4)))
    }

    @Test
    fun example3() {
        assertEquals(0, Solution().minSubArrayLen(11, intArrayOf(1, 1, 1, 1, 1, 1, 1, 1)))
    }

    @Test
    fun shortestWindowAtEnd() {
        assertEquals(3, Solution().minSubArrayLen(11, intArrayOf(1, 2, 3, 4, 5)))
    }

    @Test
    fun entireArrayRequired() {
        assertEquals(3, Solution().minSubArrayLen(6, intArrayOf(1, 2, 3)))
    }
}
