package magicsquaresingrid

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MagicSquaresInGridTest {
    private val solution = Solution()

    @Test
    fun findsMagicSquareInExampleGrid() {
        val grid = arrayOf(
            intArrayOf(4, 3, 8, 4),
            intArrayOf(9, 5, 1, 9),
            intArrayOf(2, 7, 6, 2)
        )
        assertEquals(1, solution.numMagicSquaresInside(grid))
    }

    @Test
    fun returnsZeroWhenGridIsSmallerThanThreeByThree() {
        assertEquals(0, solution.numMagicSquaresInside(arrayOf(intArrayOf(8))))
    }

    @Test
    fun countsVerticallyAdjacentMagicSquares() {
        val grid = arrayOf(
            intArrayOf(4, 9, 2),
            intArrayOf(3, 5, 7),
            intArrayOf(8, 1, 6),
            intArrayOf(4, 9, 2),
            intArrayOf(3, 5, 7),
            intArrayOf(8, 1, 6)
        )
        assertEquals(2, solution.numMagicSquaresInside(grid))
    }

    @Test
    fun rejectsRepeatedNumbersDespiteMatchingSums() {
        val grid = Array(3) { IntArray(3) { 5 } }
        assertEquals(0, solution.numMagicSquaresInside(grid))
    }
}
