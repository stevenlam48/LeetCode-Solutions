package maximumscorefromgridoperations

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumScoreFromGridOperationsTest {
    @Test
    fun exampleOne() {
        val grid = arrayOf(
            intArrayOf(0, 0, 0, 0, 0),
            intArrayOf(0, 0, 3, 0, 0),
            intArrayOf(0, 1, 0, 0, 0),
            intArrayOf(5, 0, 0, 3, 0),
            intArrayOf(0, 0, 0, 0, 2)
        )
        assertEquals(11L, Solution().maximumScore(grid))
    }

    @Test
    fun exampleTwo() {
        val grid = arrayOf(
            intArrayOf(10, 9, 0, 0, 15),
            intArrayOf(7, 1, 0, 8, 0),
            intArrayOf(5, 20, 0, 11, 0),
            intArrayOf(0, 0, 0, 1, 2),
            intArrayOf(8, 12, 1, 10, 3)
        )
        assertEquals(94L, Solution().maximumScore(grid))
    }

    @Test
    fun singleColumnHasNoOperations() {
        assertEquals(0L, Solution().maximumScore(arrayOf(intArrayOf(1), intArrayOf(2))))
    }

    @Test
    fun singleRowScoresPositiveCells() {
        assertEquals(2L, Solution().maximumScore(arrayOf(intArrayOf(1, 2))))
    }
}
