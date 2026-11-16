package maximumbalancedsubsequencesum

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumBalancedSubsequenceSumTest {
    @Test
    fun example() {
        assertEquals(14L, Solution().maxBalancedSubsequenceSum(intArrayOf(3, 3, 5, 6)))
    }

    @Test
    fun exampleWithNegatives() {
        assertEquals(13L, Solution().maxBalancedSubsequenceSum(intArrayOf(5, -1, -3, 8)))
    }

    @Test
    fun allNegative() {
        assertEquals(-1L, Solution().maxBalancedSubsequenceSum(intArrayOf(-1, -2)))
    }

    @Test
    fun singleElement() {
        assertEquals(4L, Solution().maxBalancedSubsequenceSum(intArrayOf(4)))
    }

    @Test
    fun wholeArrayBalanced() {
        assertEquals(10L, Solution().maxBalancedSubsequenceSum(intArrayOf(1, 2, 3, 4)))
    }
}
