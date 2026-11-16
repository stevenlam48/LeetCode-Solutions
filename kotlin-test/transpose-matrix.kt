package transposematrix

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class TransposeMatrixTest {
    @Test
    fun squareMatrix() {
        val actual = Solution().transpose(arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9)))
        val expected = arrayOf(intArrayOf(1, 4, 7), intArrayOf(2, 5, 8), intArrayOf(3, 6, 9))
        assertArrayEquals(expected, actual)
    }

    @Test
    fun rectangularMatrix() {
        val actual = Solution().transpose(arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6)))
        assertArrayEquals(arrayOf(intArrayOf(1, 4), intArrayOf(2, 5), intArrayOf(3, 6)), actual)
    }

    @Test
    fun singleRowAndSignedValues() {
        assertArrayEquals(arrayOf(intArrayOf(-1), intArrayOf(0), intArrayOf(2)), Solution().transpose(arrayOf(intArrayOf(-1, 0, 2))))
    }
}
