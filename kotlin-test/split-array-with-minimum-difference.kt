package splitarraywithminimumdifference

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SplitArrayWithMinimumDifferenceTest {
    @Test
    fun `splits at a three element peak`() {
        assertEquals(2L, Solution().splitArray(intArrayOf(1, 3, 2)))
    }

    @Test
    fun `chooses the closer side of the peak`() {
        assertEquals(1L, Solution().splitArray(intArrayOf(1, 2, 5, 4, 3)))
    }

    @Test
    fun `rejects multiple peaks`() {
        assertEquals(-1L, Solution().splitArray(intArrayOf(1, 4, 2, 5, 1)))
    }

    @Test
    fun `handles two adjacent peak candidates`() {
        assertEquals(0L, Solution().splitArray(intArrayOf(1, 3, 3, 1)))
    }

    @Test
    fun `allows the peak at the beginning`() {
        assertEquals(0L, Solution().splitArray(intArrayOf(3, 2, 1)))
    }

    @Test
    fun `returns the absolute value for a single element`() {
        assertEquals(5L, Solution().splitArray(intArrayOf(5)))
    }
}
