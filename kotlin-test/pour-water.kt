package pourwater

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class PourWaterTest {
    @Test
    fun standardExample() {
        assertArrayEquals(
            intArrayOf(2, 2, 2, 3, 2, 2, 2),
            Solution().pourWater(intArrayOf(2, 1, 1, 2, 1, 2, 2), 4, 3)
        )
    }

    @Test
    fun multipleDropsReachDifferentLowPoints() {
        assertArrayEquals(intArrayOf(2, 3, 3, 4), Solution().pourWater(intArrayOf(1, 2, 3, 4), 2, 2))
    }

    @Test
    fun leftBoundaryPoursRight() {
        assertArrayEquals(intArrayOf(3, 2, 2), Solution().pourWater(intArrayOf(3, 1, 2), 1, 0))
    }

    @Test
    fun flatTerrainKeepsDropAtSource() {
        assertArrayEquals(intArrayOf(1, 2, 1), Solution().pourWater(intArrayOf(1, 1, 1), 1, 1))
    }

    @Test
    fun zeroVolume() {
        assertArrayEquals(intArrayOf(3, 2, 1), Solution().pourWater(intArrayOf(3, 2, 1), 0, 1))
    }
}
