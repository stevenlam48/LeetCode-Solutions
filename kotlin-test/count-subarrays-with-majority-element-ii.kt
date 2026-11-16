package countsubarrayswithmajorityelementii

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CountSubarraysWithMajorityElementIiTest {
    private val solution = Solution()

    @Test
    fun `counts subarrays with a strict majority`() {
        assertEquals(3L, solution.countMajoritySubarrays(intArrayOf(2, 1, 2), 2))
        assertEquals(8L, solution.countMajoritySubarrays(intArrayOf(1, 2, 2, 2), 2))
    }

    @Test
    fun `returns zero when target never has a majority`() {
        assertEquals(0L, solution.countMajoritySubarrays(intArrayOf(1, 1), 2))
    }

    @Test
    fun `handles a single element`() {
        assertEquals(1L, solution.countMajoritySubarrays(intArrayOf(2), 2))
        assertEquals(0L, solution.countMajoritySubarrays(intArrayOf(1), 2))
    }

    @Test
    fun `handles empty input`() {
        assertEquals(0L, solution.countMajoritySubarrays(intArrayOf(), 2))
    }

    @Test
    fun `does not count tied subarrays`() {
        assertEquals(3L, solution.countMajoritySubarrays(intArrayOf(1, 2, 1, 2), 1))
    }
}
