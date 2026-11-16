package numberofcenteredsubarrays

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class NumberOfCenteredSubarraysTest {
    private val solution = Solution()

    @Test
    fun `counts only singletons in a strictly increasing array`() {
        assertEquals(3, solution.centeredSubarrays(intArrayOf(1, 2, 3)))
    }

    @Test
    fun `counts a longer subarray whose sum is a repeated value`() {
        assertEquals(4, solution.centeredSubarrays(intArrayOf(-1, 1, -1)))
    }

    @Test
    fun `counts every zero sum subarray`() {
        assertEquals(3, solution.centeredSubarrays(intArrayOf(0, 0)))
    }

    @Test
    fun `handles negative zero and positive values together`() {
        assertEquals(5, solution.centeredSubarrays(intArrayOf(1, -1, 0)))
    }

    @Test
    fun `returns zero for an empty array`() {
        assertEquals(0, solution.centeredSubarrays(intArrayOf()))
    }
}
