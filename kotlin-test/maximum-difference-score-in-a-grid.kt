package maximumdifferencescoreinagrid

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MaximumDifferenceScoreInAGridTest {
    @Test
    fun exampleGrid() {
        val grid = arrayOf(
            intArrayOf(9, 5, 7, 3),
            intArrayOf(8, 9, 6, 1),
            intArrayOf(6, 7, 14, 3),
            intArrayOf(2, 5, 3, 1)
        )
        assertEquals(9, Solution().maxScore(grid))
    }

    @Test
    fun strictlyDecreasingGrid() {
        val grid = arrayOf(
            intArrayOf(4, 3, 2),
            intArrayOf(3, 2, 1)
        )
        assertEquals(-1, Solution().maxScore(grid))
    }

    @Test
    fun singleRow() {
        assertEquals(5, Solution().maxScore(arrayOf(intArrayOf(1, 2, 6))))
    }

    @Test
    fun singleColumn() {
        val grid = arrayOf(intArrayOf(5), intArrayOf(2), intArrayOf(9))
        assertEquals(7, Solution().maxScore(grid))
    }
}
