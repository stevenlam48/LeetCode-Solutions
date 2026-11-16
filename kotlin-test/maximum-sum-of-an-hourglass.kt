package maximumsumofanhourglass
// Time:  O(m * n)
// Space: O(1)

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumSumOfAnHourglassTest {
    @Test
    fun exampleOne() {
        val grid = arrayOf(
            intArrayOf(6, 2, 1, 3),
            intArrayOf(4, 2, 1, 5),
            intArrayOf(9, 2, 8, 7),
            intArrayOf(4, 1, 2, 9)
        )
        assertEquals(30, Solution().maxSum(grid))
    }

    @Test
    fun singleHourglass() {
        val grid = arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(0, 1, 0),
            intArrayOf(1, 1, 1)
        )
        assertEquals(7, Solution().maxSum(grid))
    }

    @Test
    fun bestHourglassIsAtBottomRight() {
        val grid = arrayOf(
            intArrayOf(0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0),
            intArrayOf(0, 0, 1, 2, 3),
            intArrayOf(0, 0, 4, 5, 6),
            intArrayOf(0, 0, 7, 8, 9)
        )
        assertEquals(35, Solution().maxSum(grid))
    }

    @Test
    fun zeroGrid() {
        val grid = Array(4) { IntArray(5) }
        assertEquals(0, Solution().maxSum(grid))
    }
}
