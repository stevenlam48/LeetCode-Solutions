package swiminrisingwater

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SwimInRisingWaterTest {
    @Test
    fun twoByTwoGrid() {
        val grid = arrayOf(intArrayOf(0, 2), intArrayOf(1, 3))
        assertEquals(3, Solution().swimInWater(grid))
    }

    @Test
    fun largerGrid() {
        val grid = arrayOf(
            intArrayOf(0, 1, 2, 3, 4),
            intArrayOf(24, 23, 22, 21, 5),
            intArrayOf(12, 13, 14, 15, 16),
            intArrayOf(11, 17, 18, 19, 20),
            intArrayOf(10, 9, 8, 7, 6)
        )
        assertEquals(16, Solution().swimInWater(grid))
    }

    @Test
    fun singleCellAndDirectPath() {
        assertEquals(0, Solution().swimInWater(arrayOf(intArrayOf(0))))
        assertEquals(2, Solution().swimInWater(arrayOf(intArrayOf(0, 1), intArrayOf(3, 2))))
    }
}
