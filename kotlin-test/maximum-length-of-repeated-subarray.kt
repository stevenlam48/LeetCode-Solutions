package maximumlengthofrepeatedsubarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumLengthOfRepeatedSubarrayTest {
    private val solution = Solution()

    @Test
    fun `finds the longest common contiguous subarray`() {
        assertEquals(3, solution.findLength(intArrayOf(1, 2, 3, 2, 1), intArrayOf(3, 2, 1, 4, 7)))
    }

    @Test
    fun `handles repeated full arrays`() {
        assertEquals(5, solution.findLength(IntArray(5), IntArray(5)))
    }

    @Test
    fun `returns zero without common values`() {
        assertEquals(0, solution.findLength(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6)))
    }

    @Test
    fun `handles empty arrays`() {
        assertEquals(0, solution.findLength(intArrayOf(), intArrayOf(1, 2)))
        assertEquals(0, solution.findLength(intArrayOf(), intArrayOf()))
    }
}
