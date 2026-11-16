package countsubarrayswithscorelessthank

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CountSubarraysWithScoreLessThanKTest {
    private val solution = Solution()

    @Test
    fun `counts standard example`() {
        assertEquals(3L, solution.countSubarrays(intArrayOf(2, 5, 6), 10L))
    }

    @Test
    fun `excludes subarrays whose score reaches k`() {
        assertEquals(5L, solution.countSubarrays(intArrayOf(1, 1, 1), 5L))
    }

    @Test
    fun `returns zero when no subarray qualifies`() {
        assertEquals(0L, solution.countSubarrays(intArrayOf(10), 10L))
    }

    @Test
    fun `handles empty input`() {
        assertEquals(0L, solution.countSubarrays(intArrayOf(), 1L))
    }

    @Test
    fun `accepts a long threshold`() {
        assertEquals(6L, solution.countSubarrays(intArrayOf(1, 2, 3), Long.MAX_VALUE))
    }
}
