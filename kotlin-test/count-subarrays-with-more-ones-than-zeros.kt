package countsubarrayswithmoreonesthanzeros

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CountSubarraysWithMoreOnesThanZerosTest {
    private val solution = Solution()

    @Test
    fun `handles single elements and empty input`() {
        assertEquals(1, solution.subarraysWithMoreZerosThanOnes(intArrayOf(1)))
        assertEquals(0, solution.subarraysWithMoreZerosThanOnes(intArrayOf(0)))
        assertEquals(0, solution.subarraysWithMoreZerosThanOnes(intArrayOf()))
    }

    @Test
    fun `does not count equal numbers of ones and zeros`() {
        assertEquals(1, solution.subarraysWithMoreZerosThanOnes(intArrayOf(1, 0)))
        assertEquals(3, solution.subarraysWithMoreZerosThanOnes(intArrayOf(1, 0, 1)))
    }

    @Test
    fun `counts subarrays contained in longer valid subarrays`() {
        assertEquals(4, solution.subarraysWithMoreZerosThanOnes(intArrayOf(1, 1, 0)))
        assertEquals(5, solution.subarraysWithMoreZerosThanOnes(intArrayOf(0, 1, 1, 0)))
    }

    @Test
    fun `counts every subarray when all values are one`() {
        assertEquals(10, solution.subarraysWithMoreZerosThanOnes(intArrayOf(1, 1, 1, 1)))
    }
}
