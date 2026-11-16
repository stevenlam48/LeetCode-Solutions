package righttriangles

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RightTrianglesTest {
    @Test
    fun exampleOne() {
        assertEquals(2L, Solution().numberOfRightTriangles(arrayOf(
            intArrayOf(0, 1, 0), intArrayOf(0, 1, 1), intArrayOf(0, 1, 0)
        )))
    }

    @Test
    fun exampleTwo() {
        assertEquals(0L, Solution().numberOfRightTriangles(arrayOf(
            intArrayOf(1, 0, 0, 0), intArrayOf(0, 1, 0, 1), intArrayOf(1, 0, 0, 0)
        )))
    }

    @Test
    fun exampleThree() {
        assertEquals(2L, Solution().numberOfRightTriangles(arrayOf(
            intArrayOf(1, 0, 1), intArrayOf(1, 0, 0), intArrayOf(1, 0, 0)
        )))
    }

    @Test
    fun tallGrid() {
        assertEquals(6L, Solution().numberOfRightTriangles(arrayOf(
            intArrayOf(1, 1), intArrayOf(1, 0), intArrayOf(1, 1)
        )))
    }
}
