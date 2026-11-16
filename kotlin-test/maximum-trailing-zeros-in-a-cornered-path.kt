package maximumtrailingzerosinacorneredpath

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumTrailingZerosInACorneredPathTest {
    @Test
    fun examples() {
        assertEquals(
            2,
            Solution().maxTrailingZeros(arrayOf(intArrayOf(2, 5), intArrayOf(10, 4)))
        )
        assertEquals(
            2,
            Solution().maxTrailingZeros(arrayOf(intArrayOf(2, 5, 10), intArrayOf(1, 1, 5)))
        )
    }

    @Test
    fun opposingCornersCanShareAnEndpoint() {
        assertEquals(
            2,
            Solution().maxTrailingZeros(arrayOf(intArrayOf(10, 1), intArrayOf(1, 10)))
        )
    }

    @Test
    fun singleCellAndMultipleFactorPairs() {
        assertEquals(3, Solution().maxTrailingZeros(arrayOf(intArrayOf(1000))))
        assertEquals(
            2,
            Solution().maxTrailingZeros(arrayOf(intArrayOf(25, 4), intArrayOf(2, 5)))
        )
    }
}
