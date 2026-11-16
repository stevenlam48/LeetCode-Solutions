package splitarraywithsameaverage

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SplitArrayWithSameAverageTest {
    @Test
    fun `splits the standard example into equal averages`() {
        assertTrue(Solution().splitArraySameAverage(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8)))
    }

    @Test
    fun `returns false when neither singleton has the total average`() {
        assertFalse(Solution().splitArraySameAverage(intArrayOf(3, 1)))
    }

    @Test
    fun `returns false for one element`() {
        assertFalse(Solution().splitArraySameAverage(intArrayOf(5)))
    }

    @Test
    fun `supports a zero average with negative values`() {
        assertTrue(Solution().splitArraySameAverage(intArrayOf(-1, 0, 1)))
    }

    @Test
    fun `supports duplicate values`() {
        assertTrue(Solution().splitArraySameAverage(intArrayOf(2, 2, 2, 2)))
    }
}
