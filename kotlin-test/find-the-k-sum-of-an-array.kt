package findtheksumofanarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheKSumOfAnArrayTest {
    @Test
    fun example1() {
        assertEquals(2L, Solution().kSum(intArrayOf(2, 4, -2), 5))
    }

    @Test
    fun example2() {
        assertEquals(10L, Solution().kSum(intArrayOf(1, -2, 3, 4, -10, 12), 16))
    }

    @Test
    fun smallArray() {
        assertEquals(1L, Solution().kSum(intArrayOf(1, 2), 3))
    }

    @Test
    fun singlePositive() {
        assertEquals(5L, Solution().kSum(intArrayOf(5), 1))
    }

    @Test
    fun singlePositiveSecondLargest() {
        assertEquals(0L, Solution().kSum(intArrayOf(5), 2))
    }
}
