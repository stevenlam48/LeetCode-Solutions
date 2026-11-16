package floodfill

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class FloodFillTest {
    @Test
    fun standardExample() {
        val image = arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(1, 1, 0),
            intArrayOf(1, 0, 1)
        )
        val expected = arrayOf(
            intArrayOf(2, 2, 2),
            intArrayOf(2, 2, 0),
            intArrayOf(2, 0, 1)
        )
        assertArrayEquals(expected, Solution().floodFill(image, 1, 1, 2))
    }

    @Test
    fun newColorMatchesOriginal() {
        val image = arrayOf(intArrayOf(0, 0, 0), intArrayOf(0, 0, 0))
        val expected = arrayOf(intArrayOf(0, 0, 0), intArrayOf(0, 0, 0))
        assertArrayEquals(expected, Solution().floodFill(image, 0, 0, 0))
    }

    @Test
    fun singlePixel() {
        val image = arrayOf(intArrayOf(1))
        val expected = arrayOf(intArrayOf(2))
        assertArrayEquals(expected, Solution().floodFill(image, 0, 0, 2))
    }

    @Test
    fun diagonallyTouchingPixelsAreNotConnected() {
        val image = arrayOf(
            intArrayOf(1, 2, 1),
            intArrayOf(2, 1, 2),
            intArrayOf(1, 2, 1)
        )
        val expected = arrayOf(
            intArrayOf(3, 2, 1),
            intArrayOf(2, 1, 2),
            intArrayOf(1, 2, 1)
        )
        assertArrayEquals(expected, Solution().floodFill(image, 0, 0, 3))
    }
}
