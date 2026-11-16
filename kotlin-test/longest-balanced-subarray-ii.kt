package longestbalancedsubarrayii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestBalancedSubarrayIiTest {
    @Test
    fun wholeArrayBalanced() {
        assertEquals(4, Solution().longestBalanced(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun duplicateAllowsLongerSubarray() {
        assertEquals(3, Solution().longestBalanced(intArrayOf(1, 2, 1)))
        assertEquals(4, Solution().longestBalanced(intArrayOf(1, 2, 2, 1)))
    }

    @Test
    fun onlyEvenOrOnlyOdd() {
        assertEquals(0, Solution().longestBalanced(intArrayOf(2, 4, 6)))
        assertEquals(0, Solution().longestBalanced(intArrayOf(1, 3, 5)))
    }

    @Test
    fun singleElement() {
        assertEquals(0, Solution().longestBalanced(intArrayOf(1)))
        assertEquals(0, Solution().longestBalanced(intArrayOf(2)))
    }

    @Test
    fun duplicatesWithoutBalance() {
        assertEquals(0, Solution().longestBalanced(intArrayOf(1, 1)))
        assertEquals(2, Solution().longestBalanced(intArrayOf(1, 2, 3)))
    }
}
