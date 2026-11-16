package tilingarectanglewiththefewestsquares

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TilingARectangleWithTheFewestSquaresTest {
    private val solution = Solution()

    @Test
    fun twoByThreeRectangle() {
        assertEquals(3, solution.tilingRectangle(2, 3))
    }

    @Test
    fun fiveByEightRectangle() {
        assertEquals(5, solution.tilingRectangle(5, 8))
    }

    @Test
    fun elevenByThirteenRectangle() {
        assertEquals(6, solution.tilingRectangle(11, 13))
    }

    @Test
    fun squareNeedsOneTile() {
        assertEquals(1, solution.tilingRectangle(7, 7))
    }

    @Test
    fun dimensionsMayBeReversed() {
        assertEquals(3, solution.tilingRectangle(3, 2))
    }
}
