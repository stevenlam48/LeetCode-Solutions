package minimumsubarraysinavalidsplit

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MinimumSubarraysInAValidSplitTest {
    @Test
    fun example1() {
        assertEquals(2, Solution().validSubarraySplit(intArrayOf(2, 6, 3, 4, 3)))
    }

    @Test
    fun splitIntoSingletons() {
        assertEquals(2, Solution().validSubarraySplit(intArrayOf(3, 5)))
    }

    @Test
    fun onePreventsValidEndpoints() {
        assertEquals(-1, Solution().validSubarraySplit(intArrayOf(1, 2, 1)))
    }

    @Test
    fun wholeArrayIsValid() {
        assertEquals(1, Solution().validSubarraySplit(intArrayOf(2, 4, 2)))
    }

    @Test
    fun onlyOuterEndpointsMatter() {
        assertEquals(1, Solution().validSubarraySplit(intArrayOf(6, 10, 15)))
    }
}
