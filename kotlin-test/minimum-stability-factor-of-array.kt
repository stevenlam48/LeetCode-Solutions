package minimumstabilityfactorofarray

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MinimumStabilityFactorOfArrayTest {
    @Test
    fun `finds the longest stable subarray without changes`() {
        assertEquals(2, Solution().minStable(intArrayOf(6, 10, 15), 0))
    }

    @Test
    fun `uses a change to break a length-two stable subarray`() {
        assertEquals(1, Solution().minStable(intArrayOf(6, 10, 15), 1))
    }

    @Test
    fun `returns zero when every element is one`() {
        assertEquals(0, Solution().minStable(intArrayOf(1, 1, 1), 0))
    }

    @Test
    fun `returns one when every adjacent pair is coprime`() {
        assertEquals(1, Solution().minStable(intArrayOf(2, 3, 4, 5), 0))
    }

    @Test
    fun `counts separate greedy stable segments`() {
        val nums = intArrayOf(2, 4, 3, 9, 5, 7)
        assertEquals(2, Solution().minStable(nums, 0))
        assertEquals(1, Solution().minStable(nums, 2))
    }
}
