package reshapethematrix

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class ReshapeTheMatrixTest {
    @Test
    fun example1() {
        assertArrayEquals(
            arrayOf(intArrayOf(1, 2, 3, 4)),
            Solution().matrixReshape(arrayOf(intArrayOf(1, 2), intArrayOf(3, 4)), 1, 4)
        )
    }

    @Test
    fun example2() {
        assertArrayEquals(
            arrayOf(intArrayOf(1, 2), intArrayOf(3, 4)),
            Solution().matrixReshape(arrayOf(intArrayOf(1, 2), intArrayOf(3, 4)), 2, 4)
        )
    }

    @Test
    fun singleColumn() {
        assertArrayEquals(
            arrayOf(intArrayOf(1), intArrayOf(2), intArrayOf(3), intArrayOf(4)),
            Solution().matrixReshape(arrayOf(intArrayOf(1, 2), intArrayOf(3, 4)), 4, 1)
        )
    }

    @Test
    fun singleRowToSquare() {
        assertArrayEquals(
            arrayOf(intArrayOf(1, 2), intArrayOf(3, 4)),
            Solution().matrixReshape(arrayOf(intArrayOf(1, 2, 3, 4)), 2, 2)
        )
    }

    @Test
    fun sameShape() {
        assertArrayEquals(
            arrayOf(intArrayOf(1)),
            Solution().matrixReshape(arrayOf(intArrayOf(1)), 1, 1)
        )
    }

    @Test
    fun emptyInput() {
        assertArrayEquals(
            emptyArray<IntArray>(),
            Solution().matrixReshape(emptyArray(), 1, 1)
        )
    }
}
