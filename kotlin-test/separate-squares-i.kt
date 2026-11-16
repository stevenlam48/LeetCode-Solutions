package separatesquaresi

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SeparateSquaresITest {
    @Test
    fun exampleTwoSeparateSquares() {
        assertEquals(1.0, Solution().separateSquares(arrayOf(intArrayOf(0, 0, 1), intArrayOf(2, 2, 1))), 1e-5)
    }

    @Test
    fun exampleOverlappingSquares() {
        assertEquals(1.16667, Solution().separateSquares(arrayOf(intArrayOf(0, 0, 2), intArrayOf(1, 1, 1))), 1e-5)
    }

    @Test
    fun singleSquare() {
        assertEquals(1.0, Solution().separateSquares(arrayOf(intArrayOf(0, 0, 2))), 1e-5)
    }

    @Test
    fun stackedSquares() {
        assertEquals(1.0, Solution().separateSquares(arrayOf(intArrayOf(0, 0, 1), intArrayOf(0, 1, 1))), 1e-5)
    }

    @Test
    fun identicalSquares() {
        assertEquals(1.0, Solution().separateSquares(arrayOf(intArrayOf(0, 0, 2), intArrayOf(0, 0, 2))), 1e-5)
    }
}
