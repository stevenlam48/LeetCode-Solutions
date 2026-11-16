package maximumsubarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumSubarrayTest {
    @Test
    fun example1() {
        assertEquals(6, Solution().maxSubArray(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
    }

    @Test
    fun example2() {
        assertEquals(1, Solution().maxSubArray(intArrayOf(1)))
    }

    @Test
    fun example3() {
        assertEquals(23, Solution().maxSubArray(intArrayOf(5, 4, -1, 7, 8)))
    }

    @Test
    fun singleNegative() {
        assertEquals(-1, Solution().maxSubArray(intArrayOf(-1)))
    }

    @Test
    fun allNegative() {
        assertEquals(-1, Solution().maxSubArray(intArrayOf(-2, -1)))
    }
}
