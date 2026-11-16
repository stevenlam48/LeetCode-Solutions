package heaters

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class HeatersTest {
    private val solution = Solution()

    @Test
    fun oneCentralHeater() {
        assertEquals(1, solution.findRadius(intArrayOf(1, 2, 3), intArrayOf(2)))
    }

    @Test
    fun twoHeaters() {
        assertEquals(1, solution.findRadius(intArrayOf(1, 2, 3, 4), intArrayOf(1, 4)))
    }

    @Test
    fun housesOutsideHeaterRange() {
        assertEquals(3, solution.findRadius(intArrayOf(1, 5), intArrayOf(2)))
    }

    @Test
    fun unsortedHeatersAndDuplicateHouses() {
        val heaters = intArrayOf(10, 1, 5)
        assertEquals(2, solution.findRadius(intArrayOf(2, 2, 7, 9), heaters))
        assertArrayEquals(intArrayOf(1, 5, 10), heaters)
    }
}
