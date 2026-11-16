package maximumnonnegativeproductinamatrix

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumNonNegativeProductInAMatrixTest {
    private val solution = Solution()

    @Test
    fun allNegativeResult() {
        assertEquals(
            -1,
            solution.maxProductPath(
                arrayOf(
                    intArrayOf(-1, -2, -3),
                    intArrayOf(-2, -3, -3),
                    intArrayOf(-3, -3, -2)
                )
            )
        )
    }

    @Test
    fun positiveProduct() {
        assertEquals(
            8,
            solution.maxProductPath(
                arrayOf(
                    intArrayOf(1, -2, 1),
                    intArrayOf(1, -2, 1),
                    intArrayOf(3, -4, 1)
                )
            )
        )
    }

    @Test
    fun zeroProduct() {
        assertEquals(0, solution.maxProductPath(arrayOf(intArrayOf(1, 3), intArrayOf(0, -4))))
    }

    @Test
    fun singlePositiveCell() {
        assertEquals(1, solution.maxProductPath(arrayOf(intArrayOf(1))))
    }

    @Test
    fun singleNegativeCell() {
        assertEquals(-1, solution.maxProductPath(arrayOf(intArrayOf(-1))))
    }

    @Test
    fun twoByTwo() {
        assertEquals(40, solution.maxProductPath(arrayOf(intArrayOf(2, 3), intArrayOf(4, 5))))
    }
}
