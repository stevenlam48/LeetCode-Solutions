package maximumnumberofmovesinagrid

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MaximumNumberOfMovesInAGridTest {
    private val solution = Solution()

    @Test
    fun standardExampleWithThreeMoves() {
        val grid = arrayOf(
            intArrayOf(2, 4, 3, 5),
            intArrayOf(5, 4, 9, 3),
            intArrayOf(3, 4, 2, 11),
            intArrayOf(10, 9, 13, 15)
        )
        assertEquals(3, solution.maxMoves(grid))
    }

    @Test
    fun standardExampleWithNoMoves() {
        val grid = arrayOf(intArrayOf(3, 2, 4), intArrayOf(2, 1, 9), intArrayOf(1, 1, 7))
        assertEquals(0, solution.maxMoves(grid))
    }

    @Test
    fun singleColumn() {
        assertEquals(0, solution.maxMoves(arrayOf(intArrayOf(1), intArrayOf(2))))
    }

    @Test
    fun twoColumns() {
        val grid = arrayOf(intArrayOf(1, 2), intArrayOf(2, 1))
        assertEquals(1, solution.maxMoves(grid))
    }
}
