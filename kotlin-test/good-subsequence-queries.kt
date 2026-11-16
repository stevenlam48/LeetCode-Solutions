package goodsubsequencequeries

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GoodSubsequenceQueriesTest {
    @Test
    fun `single element always gives zero`() {
        assertEquals(0, Solution().countGoodSubseq(intArrayOf(2), 2, arrayOf(intArrayOf(0, 4), intArrayOf(0, 3))))
    }

    @Test
    fun `persistent queries count good states`() {
        val nums = intArrayOf(6, 12)
        val queries = arrayOf(intArrayOf(0, 6), intArrayOf(1, 5), intArrayOf(1, 12))
        assertEquals(0, Solution().countGoodSubseq(nums, 1, queries))
        assertEquals(6, nums[0])
        assertEquals(12, nums[1])
    }

    @Test
    fun `nonmultiples and disjoint prime factors`() {
        val solution = Solution()
        assertEquals(1, solution.countGoodSubseq(intArrayOf(2, 3), 2, arrayOf(intArrayOf(0, 2))))
        assertEquals(1, solution.countGoodSubseq(intArrayOf(6, 10, 15), 1, arrayOf(intArrayOf(0, 6), intArrayOf(2, 21))))
    }
}
