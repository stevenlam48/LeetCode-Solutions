package smallestrectangleenclosingblackpixels

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SmallestRectangleEnclosingBlackPixelsTest {
    private val solution = Solution()

    private fun imageOf(vararg rows: String): Array<CharArray> =
        rows.map { it.toCharArray() }.toTypedArray()

    @Test
    fun example() {
        val image = imageOf("0010", "0110", "0100")
        assertEquals(6, solution.minArea(image, 1, 2))
    }

    @Test
    fun singleBlackPixel() {
        assertEquals(1, solution.minArea(imageOf("1"), 0, 0))
    }

    @Test
    fun disconnectedBlackPixels() {
        val image = imageOf("1000", "1100", "0111")
        assertEquals(12, solution.minArea(image, 0, 0))
    }

    @Test
    fun verticalAndHorizontalLines() {
        val vertical = imageOf("010", "010", "010")
        assertEquals(3, solution.minArea(vertical, 1, 1))
        val horizontal = imageOf("000", "111", "000")
        assertEquals(3, solution.minArea(horizontal, 1, 1))
    }
}
