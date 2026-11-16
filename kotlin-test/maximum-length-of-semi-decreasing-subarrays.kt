package maximumlengthofsemidecreasingsubarrays

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumLengthOfSemiDecreasingSubarraysTest {
    private val solution = Solution()

    @Test
    fun `uses a later smaller value as the endpoint`() {
        assertEquals(8, solution.maxSubarrayLength(intArrayOf(7, 6, 5, 4, 3, 2, 1, 6)))
    }

    @Test
    fun `returns zero for an increasing array`() {
        assertEquals(0, solution.maxSubarrayLength(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun `finds a short decreasing span`() {
        assertEquals(2, solution.maxSubarrayLength(intArrayOf(1, 3, 2)))
    }

    @Test
    fun `does not count equal endpoints`() {
        assertEquals(0, solution.maxSubarrayLength(intArrayOf(2, 2)))
    }
}
