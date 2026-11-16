package maximumvaluesumbyplacingthreerooksi

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumValueSumByPlacingThreeRooksITest {
    private val solution = Solution()

    @Test
    fun exampleOne() {
        val board = arrayOf(
            intArrayOf(-3, 1, 1, 1),
            intArrayOf(-3, 1, -3, 1),
            intArrayOf(-3, 2, 1, 1)
        )
        assertEquals(4L, solution.maximumValueSum(board))
    }

    @Test
    fun increasingBoard() {
        val board = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
        )
        assertEquals(15L, solution.maximumValueSum(board))
    }

    @Test
    fun allOnes() {
        val board = arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(1, 1, 1),
            intArrayOf(1, 1, 1)
        )
        assertEquals(3L, solution.maximumValueSum(board))
    }

    @Test
    fun allNegativeBoard() {
        val board = arrayOf(
            intArrayOf(-1, -2, -3),
            intArrayOf(-4, -5, -6),
            intArrayOf(-7, -8, -9)
        )
        assertEquals(-15L, solution.maximumValueSum(board))
    }
}
