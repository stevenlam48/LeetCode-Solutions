package getthemaximumscore

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GetTheMaximumScoreTest {
    @Test
    fun `standard examples`() {
        val solution = Solution()
        assertEquals(30, solution.maxSum(intArrayOf(2, 4, 5, 8, 10), intArrayOf(4, 6, 8, 9)))
        assertEquals(29, solution.maxSum(intArrayOf(1, 3, 5, 7, 9), intArrayOf(3, 4, 5, 6)))
        assertEquals(40, solution.maxSum(intArrayOf(1, 2, 3, 4, 5), intArrayOf(6, 7, 8, 9, 10)))
    }

    @Test
    fun `multiple common elements`() {
        val nums1 = intArrayOf(1, 4, 5, 8, 9, 11, 19)
        val nums2 = intArrayOf(2, 3, 4, 11, 12)
        assertEquals(61, Solution().maxSum(nums1, nums2))
    }

    @Test
    fun `empty arrays and modulo`() {
        val solution = Solution()
        assertEquals(6, solution.maxSum(intArrayOf(), intArrayOf(1, 2, 3)))
        assertEquals(4, solution.maxSum(intArrayOf(4), intArrayOf()))
        assertEquals(999_999_993, solution.maxSum(intArrayOf(1_000_000_000, 1_000_000_000), intArrayOf(1_000_000_000, 1_000_000_000)))
    }
}
