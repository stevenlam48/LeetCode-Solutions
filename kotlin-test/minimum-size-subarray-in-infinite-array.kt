package minimumsizesubarrayininfinitearray

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MinimumSizeSubarrayInInfiniteArrayTest {
    @Test
    fun example1() {
        assertEquals(2, Solution().minSizeSubarray(intArrayOf(1, 2, 3), 5))
    }

    @Test
    fun example2() {
        assertEquals(2, Solution().minSizeSubarray(intArrayOf(1, 1, 1, 2, 3), 4))
    }

    @Test
    fun example3() {
        assertEquals(-1, Solution().minSizeSubarray(intArrayOf(2, 4, 6, 8), 3))
    }

    @Test
    fun exactWholeRepeats() {
        assertEquals(4, Solution().minSizeSubarray(intArrayOf(1, 2), 6))
    }

    @Test
    fun partialArrayAfterWholeRepeats() {
        assertEquals(5, Solution().minSizeSubarray(intArrayOf(1, 2), 7))
    }
}
