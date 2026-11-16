package smallestrangei

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SmallestRangeITest {
    private val solution = Solution()

    @Test
    fun examples() {
        assertEquals(0, solution.smallestRangeI(intArrayOf(1), 0))
        assertEquals(6, solution.smallestRangeI(intArrayOf(0, 10), 2))
        assertEquals(0, solution.smallestRangeI(intArrayOf(1, 3, 6), 3))
    }

    @Test
    fun adjustmentCanCoverWholeRange() {
        assertEquals(0, solution.smallestRangeI(intArrayOf(-5, -2, 8), 10))
    }

    @Test
    fun negativeValuesAndZeroAdjustment() {
        assertEquals(7, solution.smallestRangeI(intArrayOf(-4, -1, 3), 0))
    }
}
