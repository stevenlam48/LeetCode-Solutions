package maximumheightbystackingcuboids

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumHeightByStackingCuboidsTest {
    private val solution = Solution()

    @Test
    fun `stacks cuboids after sorting dimensions`() {
        val cuboids = arrayOf(
            intArrayOf(50, 45, 20),
            intArrayOf(95, 37, 53),
            intArrayOf(45, 23, 12)
        )
        assertEquals(190, solution.maxHeight(cuboids))
    }

    @Test
    fun `stacks equal and strictly decreasing cuboids`() {
        val cuboids = arrayOf(intArrayOf(10, 10, 10), intArrayOf(9, 9, 9), intArrayOf(8, 8, 8))
        assertEquals(27, solution.maxHeight(cuboids))
    }

    @Test
    fun `handles a single cuboid`() {
        assertEquals(4, solution.maxHeight(arrayOf(intArrayOf(4, 3, 2))))
    }

    @Test
    fun `handles no cuboids`() {
        assertEquals(0, solution.maxHeight(arrayOf()))
    }
}
