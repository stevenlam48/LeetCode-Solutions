package luckynumbersinamatrix

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LuckyNumbersInAMatrixTest {
    @Test
    fun findsLuckyNumberInSquareMatrix() {
        val matrix = arrayOf(
            intArrayOf(3, 7, 8),
            intArrayOf(9, 11, 13),
            intArrayOf(15, 16, 17)
        )
        assertEquals(listOf(15), Solution().luckyNumbers(matrix))
    }

    @Test
    fun findsLuckyNumberInRectangularMatrix() {
        val matrix = arrayOf(
            intArrayOf(1, 10, 4, 2),
            intArrayOf(9, 3, 8, 7),
            intArrayOf(15, 16, 17, 12)
        )
        assertEquals(listOf(12), Solution().luckyNumbers(matrix))
    }

    @Test
    fun returnsEveryMatchingCellWithDuplicates() {
        val matrix = arrayOf(intArrayOf(2, 2), intArrayOf(2, 2))
        assertEquals(listOf(2, 2, 2, 2), Solution().luckyNumbers(matrix))
    }

    @Test
    fun handlesSingleRowAndSingleCell() {
        assertEquals(listOf(1), Solution().luckyNumbers(arrayOf(intArrayOf(3, 1, 2))))
        assertEquals(listOf(7), Solution().luckyNumbers(arrayOf(intArrayOf(7))))
    }
}
