package largestmagicsquare

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LargestMagicSquareTest {
    @Test
    fun loShuSquare() {
        val grid = arrayOf(intArrayOf(4, 9, 2), intArrayOf(3, 5, 7), intArrayOf(8, 1, 6))
        assertEquals(3, Solution().largestMagicSquare(grid))
    }

    @Test
    fun onlySingleCellMagicSquares() {
        val grid = arrayOf(intArrayOf(1, 2), intArrayOf(3, 4))
        assertEquals(1, Solution().largestMagicSquare(grid))
    }

    @Test
    fun equalValuesMakeWholeSquareMagic() {
        val grid = arrayOf(intArrayOf(1, 1), intArrayOf(1, 1))
        assertEquals(2, Solution().largestMagicSquare(grid))
    }

    @Test
    fun largestSquareCanBeOffCenter() {
        val grid = arrayOf(
            intArrayOf(0, 0, 0, 0),
            intArrayOf(0, 4, 9, 2),
            intArrayOf(0, 3, 5, 7),
            intArrayOf(0, 8, 1, 6)
        )
        assertEquals(3, Solution().largestMagicSquare(grid))
    }
}
