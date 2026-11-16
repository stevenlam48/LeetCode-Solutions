package spiralmatrix

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SpiralMatrixTest {
    @Test
    fun squareMatrix() {
        val matrix = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
        )
        assertEquals(listOf(1, 2, 3, 6, 9, 8, 7, 4, 5), Solution().spiralOrder(matrix))
    }

    @Test
    fun rectangularMatrix() {
        val matrix = arrayOf(
            intArrayOf(1, 2, 3, 4),
            intArrayOf(5, 6, 7, 8),
            intArrayOf(9, 10, 11, 12)
        )
        assertEquals(listOf(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7), Solution().spiralOrder(matrix))
    }

    @Test
    fun singleCell() {
        assertEquals(listOf(1), Solution().spiralOrder(arrayOf(intArrayOf(1))))
    }

    @Test
    fun emptyMatrix() {
        assertEquals(emptyList<Int>(), Solution().spiralOrder(emptyArray()))
    }

    @Test
    fun singleRow() {
        assertEquals(listOf(1, 2, 3), Solution().spiralOrder(arrayOf(intArrayOf(1, 2, 3))))
    }
}
