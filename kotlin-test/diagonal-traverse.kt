package diagonaltraverse

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class DiagonalTraverseTest {
    private val solution = Solution()

    @Test
    fun squareMatrixTraversesDiagonals() {
        val matrix = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
        )
        assertArrayEquals(intArrayOf(1, 2, 4, 7, 5, 3, 6, 8, 9), solution.findDiagonalOrder(matrix))
    }

    @Test
    fun rectangularMatrixTraversesDiagonals() {
        val matrix = arrayOf(intArrayOf(1, 2), intArrayOf(3, 4))
        assertArrayEquals(intArrayOf(1, 2, 3, 4), solution.findDiagonalOrder(matrix))
    }

    @Test
    fun wideMatrixTraversesDiagonals() {
        val matrix = arrayOf(intArrayOf(1, 2, 3, 4), intArrayOf(5, 6, 7, 8))
        assertArrayEquals(intArrayOf(1, 2, 5, 6, 3, 4, 7, 8), solution.findDiagonalOrder(matrix))
    }

    @Test
    fun singleRowAndColumnTraverseInOrder() {
        assertArrayEquals(intArrayOf(1, 2, 3), solution.findDiagonalOrder(arrayOf(intArrayOf(1, 2, 3))))
        assertArrayEquals(
            intArrayOf(1, 2, 3),
            solution.findDiagonalOrder(arrayOf(intArrayOf(1), intArrayOf(2), intArrayOf(3)))
        )
    }

    @Test
    fun emptyMatrixReturnsEmptyArray() {
        assertArrayEquals(intArrayOf(), solution.findDiagonalOrder(arrayOf()))
        assertArrayEquals(intArrayOf(), solution.findDiagonalOrder(arrayOf(intArrayOf())))
    }
}
