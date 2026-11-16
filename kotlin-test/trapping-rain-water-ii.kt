package trappingrainwaterii

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class TrappingRainWaterIiTest {
    @Test
    fun standardExamples() {
        assertEquals(4, Solution().trapRainWater(arrayOf(
            intArrayOf(1, 4, 3, 1, 3, 2), intArrayOf(3, 2, 1, 3, 2, 4), intArrayOf(2, 3, 3, 2, 3, 1))))
        assertEquals(10, Solution().trapRainWater(arrayOf(
            intArrayOf(3, 3, 3, 3, 3), intArrayOf(3, 2, 2, 2, 3),
            intArrayOf(3, 2, 1, 2, 3), intArrayOf(3, 2, 2, 2, 3), intArrayOf(3, 3, 3, 3, 3))))
    }

    @Test
    fun noInteriorCanTrapWater() {
        assertEquals(0, Solution().trapRainWater(arrayOf(intArrayOf(1, 2, 3))))
        assertEquals(0, Solution().trapRainWater(arrayOf(intArrayOf(1), intArrayOf(2), intArrayOf(3))))
        assertEquals(0, Solution().trapRainWater(arrayOf()))
    }

    @Test
    fun deeperBasinUsesLowestBoundary() {
        assertEquals(9, Solution().trapRainWater(arrayOf(
            intArrayOf(5, 5, 5, 5), intArrayOf(5, 1, 0, 5), intArrayOf(5, 5, 5, 5))))
    }
}
