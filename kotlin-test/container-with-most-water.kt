package containerwithmostwater

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ContainerWithMostWaterTest {
    @Test
    fun leetCodeExample() {
        assertEquals(49, Solution().maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)))
    }

    @Test
    fun twoEqualHeights() {
        assertEquals(1, Solution().maxArea(intArrayOf(1, 1)))
    }

    @Test
    fun fewerThanTwoHeightsHoldNoWater() {
        assertEquals(0, Solution().maxArea(intArrayOf()))
        assertEquals(0, Solution().maxArea(intArrayOf(5)))
    }

    @Test
    fun equalEndpointsMoveBothPointers() {
        assertEquals(8, Solution().maxArea(intArrayOf(4, 4, 4)))
    }
}
