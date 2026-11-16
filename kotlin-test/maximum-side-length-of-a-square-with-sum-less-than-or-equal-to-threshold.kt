package maximumsidelengthofasquarewithsumlessthanorequaltothreshold

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumSideLengthOfASquareWithSumLessThanOrEqualToThresholdTest {
    private val mat = arrayOf(
        intArrayOf(1, 1, 3, 2, 4, 3, 2),
        intArrayOf(1, 1, 3, 2, 4, 3, 2),
        intArrayOf(1, 1, 3, 2, 4, 3, 2)
    )

    @Test
    fun example1() {
        assertEquals(2, Solution().maxSideLength(mat, 4))
    }

    @Test
    fun example2() {
        assertEquals(3, Solution().maxSideLength(mat, 17))
    }

    @Test
    fun allOnes() {
        val grid = arrayOf(
            intArrayOf(1, 1, 1, 1),
            intArrayOf(1, 1, 1, 1),
            intArrayOf(1, 1, 1, 1),
            intArrayOf(1, 1, 1, 1)
        )
        assertEquals(2, Solution().maxSideLength(grid, 4))
    }

    @Test
    fun singleCell() {
        assertEquals(1, Solution().maxSideLength(arrayOf(intArrayOf(1)), 1))
    }

    @Test
    fun tooSmallThreshold() {
        assertEquals(0, Solution().maxSideLength(arrayOf(intArrayOf(2, 2), intArrayOf(2, 2)), 1))
    }
}
