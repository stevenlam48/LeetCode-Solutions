package findxsumofallklongsubarraysi

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FindXSumOfAllKLongSubarraysITest {
    @Test
    fun firstExample() {
        val nums = intArrayOf(1, 1, 2, 2, 3, 4, 2, 3)
        assertArrayEquals(intArrayOf(6, 10, 12), Solution().findXSum(nums, 6, 2))
    }

    @Test
    fun secondExample() {
        val nums = intArrayOf(3, 8, 7, 8, 7, 5)
        assertArrayEquals(intArrayOf(11, 15, 15, 15, 12), Solution().findXSum(nums, 2, 2))
    }

    @Test
    fun equalFrequenciesPreferLargerValues() {
        val nums = intArrayOf(1, 2, 2, 1, 3, 3)
        assertArrayEquals(intArrayOf(6, 7, 8), Solution().findXSum(nums, 4, 2))
    }

    @Test
    fun singleElementWindows() {
        val nums = intArrayOf(-3, -1, -1, 0)
        assertArrayEquals(intArrayOf(-3, -1, -1, 0), Solution().findXSum(nums, 1, 1))
    }

    @Test
    fun xExceedsDistinctValueCount() {
        val nums = intArrayOf(2, 2, 1)
        assertArrayEquals(intArrayOf(5), Solution().findXSum(nums, 3, 5))
    }
}
