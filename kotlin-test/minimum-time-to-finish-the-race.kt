package minimumtimetofinishtherace

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumTimeToFinishTheRaceTest {
    @Test
    fun changingTires() {
        val tires = arrayOf(intArrayOf(2, 3), intArrayOf(3, 4))
        assertEquals(21, Solution().minimumFinishTime(tires, 5, 4))
    }

    @Test
    fun slowTireWear() {
        assertEquals(29, Solution().minimumFinishTime(arrayOf(intArrayOf(1, 10)), 6, 5))
    }

    @Test
    fun oneLap() {
        val tires = arrayOf(intArrayOf(7, 2), intArrayOf(3, 5))
        assertEquals(3, Solution().minimumFinishTime(tires, 4, 1))
    }

    @Test
    fun minimalChangeTime() {
        val tires = arrayOf(intArrayOf(2, 2), intArrayOf(3, 4))
        assertEquals(10, Solution().minimumFinishTime(tires, 2, 3))
    }
}
