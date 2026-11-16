package maximumlengthofsubarraywithpositiveproduct

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumLengthOfSubarrayWithPositiveProductTest {
    private val solution = Solution()

    @Test
    fun `handles two negative values`() {
        assertEquals(4, solution.getMaxLen(intArrayOf(1, -2, -3, 4)))
    }

    @Test
    fun `resets at zero and excludes an extra negative value`() {
        assertEquals(3, solution.getMaxLen(intArrayOf(0, 1, -2, -3, -4)))
    }

    @Test
    fun `returns zero for one negative value`() {
        assertEquals(0, solution.getMaxLen(intArrayOf(-1)))
    }

    @Test
    fun `handles positive values and all zero values`() {
        assertEquals(3, solution.getMaxLen(intArrayOf(1, 2, 3)))
        assertEquals(0, solution.getMaxLen(intArrayOf(0, 0)))
    }
}
