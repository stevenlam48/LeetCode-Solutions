package findmaximumbalancedxorsubarraylength

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindMaximumBalancedXorSubarrayLengthTest {
    @Test
    fun wholeArrayBalanced() {
        assertEquals(4, Solution().maxBalancedSubarray(intArrayOf(1, 2, 1, 2)))
    }

    @Test
    fun trailingZeros() {
        assertEquals(4, Solution().maxBalancedSubarray(intArrayOf(1, 2, 3, 0, 0)))
    }

    @Test
    fun pairOfEvens() {
        assertEquals(4, Solution().maxBalancedSubarray(intArrayOf(1, 1, 2, 2)))
    }

    @Test
    fun noBalancedSubarray() {
        assertEquals(0, Solution().maxBalancedSubarray(intArrayOf(1, 2, 3)))
    }

    @Test
    fun singleElement() {
        assertEquals(0, Solution().maxBalancedSubarray(intArrayOf(7)))
    }

    @Test
    fun emptyArray() {
        assertEquals(0, Solution().maxBalancedSubarray(intArrayOf()))
    }
}
