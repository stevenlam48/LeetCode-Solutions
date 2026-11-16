package paintingagridwiththreedifferentcolors

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PaintingAGridWithThreeDifferentColorsTest {
    private val solution = Solution()

    @Test
    fun examples() {
        assertEquals(3, solution.colorTheGrid(1, 1))
        assertEquals(6, solution.colorTheGrid(1, 2))
        assertEquals(54, solution.colorTheGrid(2, 3))
    }

    @Test
    fun squareGrid() {
        assertEquals(246, solution.colorTheGrid(3, 3))
    }

    @Test
    fun transposedDimensions() {
        assertEquals(solution.colorTheGrid(2, 3), solution.colorTheGrid(3, 2))
    }

    @Test
    fun largerExample() {
        assertEquals(580986, solution.colorTheGrid(5, 5))
    }
}
