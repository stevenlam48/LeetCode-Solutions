package maximumheightofatriangle

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumHeightOfATriangleTest {
    private val solution = Solution()

    @Test
    fun `chooses the best starting color`() {
        assertEquals(3, solution.maxHeightOfTriangle(2, 4))
    }

    @Test
    fun `handles balls sufficient for two rows`() {
        assertEquals(2, solution.maxHeightOfTriangle(2, 1))
    }

    @Test
    fun `handles equal ball counts`() {
        assertEquals(2, solution.maxHeightOfTriangle(3, 3))
    }

    @Test
    fun `handles zero balls`() {
        assertEquals(0, solution.maxHeightOfTriangle(0, 0))
        assertEquals(1, solution.maxHeightOfTriangle(1, 0))
    }
}
