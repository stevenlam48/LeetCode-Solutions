package maximumgoodsubarraysum

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumGoodSubarraySumTest {
    private val solution = Solution()

    @Test
    fun `finds the maximum good subarray sum`() {
        assertEquals(11L, solution.maximumSubarraySum(intArrayOf(1, 2, 3, 4, 5, 6), 1))
    }

    @Test
    fun `returns zero when no good subarray exists`() {
        assertEquals(0L, solution.maximumSubarraySum(intArrayOf(1, 5), 1))
    }

    @Test
    fun `supports negative good subarray sums`() {
        assertEquals(-6L, solution.maximumSubarraySum(intArrayOf(-1, -2, -3, -4), 2))
    }

    @Test
    fun `handles an empty input`() {
        assertEquals(0L, solution.maximumSubarraySum(intArrayOf(), 1))
    }
}
