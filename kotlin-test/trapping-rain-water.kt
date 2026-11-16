package trappingrainwater

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class TrappingRainWaterTest {
    @Test
    fun standardExamples() {
        assertEquals(6, Solution().trap(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)))
        assertEquals(9, Solution().trap(intArrayOf(4, 2, 0, 3, 2, 5)))
    }

    @Test
    fun emptySingleAndFlatArrays() {
        assertEquals(0, Solution().trap(IntArray(0)))
        assertEquals(0, Solution().trap(intArrayOf(3)))
        assertEquals(0, Solution().trap(intArrayOf(2, 2, 2)))
    }

    @Test
    fun simpleBasin() {
        assertEquals(5, Solution().trap(intArrayOf(3, 0, 1, 0, 2)))
    }
}
