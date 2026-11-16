package longeststrictlyincreasingorstrictlydecreasingsubarray

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LongestStrictlyIncreasingOrStrictlyDecreasingSubarrayTest {
    @Test
    fun increasingTailIsLongest() {
        assertEquals(3, Solution().longestMonotonicSubarray(intArrayOf(1, 4, 1, 2, 3)))
    }

    @Test
    fun entireArrayCanBeStrictlyIncreasing() {
        assertEquals(5, Solution().longestMonotonicSubarray(intArrayOf(1, 2, 3, 4, 5)))
    }

    @Test
    fun entireArrayCanBeStrictlyDecreasing() {
        assertEquals(5, Solution().longestMonotonicSubarray(intArrayOf(5, 4, 3, 2, 1)))
    }

    @Test
    fun equalValuesBreakBothDirections() {
        assertEquals(2, Solution().longestMonotonicSubarray(intArrayOf(1, 1, 5)))
    }

    @Test
    fun singleElement() {
        assertEquals(1, Solution().longestMonotonicSubarray(intArrayOf(1)))
    }
}
