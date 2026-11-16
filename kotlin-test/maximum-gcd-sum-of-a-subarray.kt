package maximumgcdsumofasubarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumGcdSumOfASubarrayTest {
    @Test
    fun example1() {
        assertEquals(48L, Solution().maxGcdSum(intArrayOf(2, 1, 4, 4, 4, 2), 2))
    }

    @Test
    fun example2() {
        assertEquals(81L, Solution().maxGcdSum(intArrayOf(7, 3, 9, 4), 1))
    }

    @Test
    fun singleElement() {
        assertEquals(25L, Solution().maxGcdSum(intArrayOf(5), 1))
    }

    @Test
    fun allEqual() {
        assertEquals(36L, Solution().maxGcdSum(intArrayOf(3, 3, 3, 3), 2))
    }

    @Test
    fun wholeArrayRequired() {
        assertEquals(24L, Solution().maxGcdSum(intArrayOf(2, 4, 6), 3))
    }
}
