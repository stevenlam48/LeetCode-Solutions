package maximumproductsubarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumProductSubarrayTest {
    @Test
    fun example1() {
        assertEquals(6, Solution().maxProduct(intArrayOf(2, 3, -2, 4)))
    }

    @Test
    fun example2() {
        assertEquals(0, Solution().maxProduct(intArrayOf(-2, 0, -1)))
    }

    @Test
    fun twoNegatives() {
        assertEquals(24, Solution().maxProduct(intArrayOf(-2, 3, -4)))
    }

    @Test
    fun singleNegative() {
        assertEquals(-2, Solution().maxProduct(intArrayOf(-2)))
    }

    @Test
    fun zeros() {
        assertEquals(2, Solution().maxProduct(intArrayOf(0, 2)))
    }
}
