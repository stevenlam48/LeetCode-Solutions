package maximumareaoflongestdiagonalrectangle

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumAreaOfLongestDiagonalRectangleTest {
    private val solution = Solution()

    @Test
    fun longestDiagonalWins() {
        assertEquals(48, solution.areaOfMaxDiagonal(arrayOf(intArrayOf(9, 3), intArrayOf(8, 6))))
    }

    @Test
    fun additionalRectangle() {
        val dimensions = arrayOf(intArrayOf(2, 6), intArrayOf(5, 4), intArrayOf(3, 7))
        assertEquals(21, solution.areaOfMaxDiagonal(dimensions))
    }

    @Test
    fun diagonalTieUsesLargerArea() {
        val dimensions = arrayOf(intArrayOf(1, 7), intArrayOf(5, 5), intArrayOf(7, 1))
        assertEquals(25, solution.areaOfMaxDiagonal(dimensions))
    }

    @Test
    fun singleRectangle() {
        assertEquals(35, solution.areaOfMaxDiagonal(arrayOf(intArrayOf(5, 7))))
    }
}
