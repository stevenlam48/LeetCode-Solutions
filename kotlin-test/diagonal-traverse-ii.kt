package diagonaltraverseii

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class DiagonalTraverseIiTest {
    private val solution = Solution()

    @Test
    fun squareMatrixTraversesDiagonals() {
        val nums = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
        )
        assertArrayEquals(intArrayOf(1, 4, 2, 7, 5, 3, 8, 6, 9), solution.findDiagonalOrder(nums))
    }

    @Test
    fun raggedMatrixTraversesDiagonals() {
        val nums = arrayOf(
            intArrayOf(1, 2, 3, 4, 5),
            intArrayOf(6, 7),
            intArrayOf(8),
            intArrayOf(9, 10, 11),
            intArrayOf(12, 13, 14, 15, 16)
        )
        assertArrayEquals(
            intArrayOf(1, 6, 2, 8, 7, 3, 9, 4, 12, 10, 5, 13, 11, 14, 15, 16),
            solution.findDiagonalOrder(nums)
        )
    }

    @Test
    fun decreasingRowLengthsTraverseCorrectly() {
        val nums = arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5), intArrayOf(6))
        assertArrayEquals(intArrayOf(1, 4, 2, 6, 5, 3), solution.findDiagonalOrder(nums))
    }

    @Test
    fun singleRowReturnsItself() {
        assertArrayEquals(intArrayOf(4, 8, 15), solution.findDiagonalOrder(arrayOf(intArrayOf(4, 8, 15))))
    }

    @Test
    fun emptyInputReturnsEmptyArray() {
        assertArrayEquals(intArrayOf(), solution.findDiagonalOrder(arrayOf()))
    }
}
