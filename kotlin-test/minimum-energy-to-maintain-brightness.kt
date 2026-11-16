package minimumenergytomaintainbrightness

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumEnergyToMaintainBrightnessTest {
    @Test
    fun overlappingIntervals() {
        val intervals = arrayOf(intArrayOf(1, 3), intArrayOf(2, 5))
        assertEquals(5L, Solution().minEnergy(6, 3, intervals))
    }

    @Test
    fun disjointIntervals() {
        val intervals = arrayOf(intArrayOf(1, 2), intArrayOf(5, 6))
        assertEquals(8L, Solution().minEnergy(10, 4, intervals))
    }

    @Test
    fun adjacentIntervalsMerge() {
        val intervals = arrayOf(intArrayOf(1, 2), intArrayOf(3, 4))
        assertEquals(4L, Solution().minEnergy(5, 2, intervals))
    }

    @Test
    fun unsortedIntervals() {
        val intervals = arrayOf(intArrayOf(5, 6), intArrayOf(1, 2))
        assertEquals(4L, Solution().minEnergy(10, 1, intervals))
    }
}
