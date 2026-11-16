package splitarraywithequalsum

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SplitArrayWithEqualSumTest {
    @Test
    fun `returns true for four equal nonzero sums`() {
        assertTrue(Solution().splitArray(intArrayOf(1, 2, 1, 2, 1, 2, 1)))
    }

    @Test
    fun `returns false when the last three parts do not match`() {
        assertFalse(Solution().splitArray(intArrayOf(1, 2, 1, 2, 1, 2, 2)))
    }

    @Test
    fun `supports negative values in every part`() {
        assertTrue(Solution().splitArray(intArrayOf(-1, 1, -1, 1, -1, 1, -1)))
    }

    @Test
    fun `returns false when fewer than seven elements are provided`() {
        assertFalse(Solution().splitArray(IntArray(6)))
    }

    @Test
    fun `supports four empty zero sum parts`() {
        assertTrue(Solution().splitArray(IntArray(7)))
    }
}
