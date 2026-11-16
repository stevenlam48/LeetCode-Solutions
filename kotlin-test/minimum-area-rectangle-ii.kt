package minimumarearectangleii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumAreaRectangleIiTest {
    @Test
    fun rotatedAndAxisAlignedExample() = assertEquals(1.0, Solution().minAreaFreeRect(arrayOf(
        intArrayOf(0, 1), intArrayOf(2, 1), intArrayOf(1, 1), intArrayOf(1, 0), intArrayOf(2, 0)
    )))

    @Test
    fun rotatedSquare() = assertEquals(2.0, Solution().minAreaFreeRect(arrayOf(
        intArrayOf(1, 2), intArrayOf(2, 1), intArrayOf(1, 0), intArrayOf(0, 1)
    )))

    @Test
    fun noRectangle() = assertEquals(0.0, Solution().minAreaFreeRect(arrayOf(
        intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(1, 2), intArrayOf(2, 0), intArrayOf(2, 2)
    )))
}
