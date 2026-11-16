package minimumarearectangle

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumAreaRectangleTest {
    @Test
    fun standardExample() = assertEquals(4, Solution().minAreaRect(arrayOf(
        intArrayOf(1, 1), intArrayOf(1, 3), intArrayOf(3, 1), intArrayOf(3, 3), intArrayOf(2, 2)
    )))

    @Test
    fun twoRectangles() = assertEquals(2, Solution().minAreaRect(arrayOf(
        intArrayOf(1, 1), intArrayOf(1, 3), intArrayOf(3, 1), intArrayOf(3, 3),
        intArrayOf(4, 1), intArrayOf(4, 3)
    )))

    @Test
    fun noRectangle() = assertEquals(0, Solution().minAreaRect(arrayOf(
        intArrayOf(0, 0), intArrayOf(1, 2), intArrayOf(3, 1)
    )))

    @Test
    fun negativeCoordinates() = assertEquals(4, Solution().minAreaRect(arrayOf(
        intArrayOf(-2, -1), intArrayOf(-2, 1), intArrayOf(0, -1), intArrayOf(0, 1)
    )))
}
