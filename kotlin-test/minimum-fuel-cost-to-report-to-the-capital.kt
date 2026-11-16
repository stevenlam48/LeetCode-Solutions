package minimumfuelcosttoreporttothecapital

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumFuelCostToReportToTheCapitalTest {
    @Test
    fun example1() {
        val roads = arrayOf(intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(0, 3))
        assertEquals(3L, Solution().minimumFuelCost(roads, 5))
    }

    @Test
    fun example2() {
        val roads = arrayOf(
            intArrayOf(3, 1),
            intArrayOf(3, 2),
            intArrayOf(1, 0),
            intArrayOf(0, 4),
            intArrayOf(0, 5),
            intArrayOf(4, 6)
        )
        assertEquals(7L, Solution().minimumFuelCost(roads, 2))
    }

    @Test
    fun noRoads() {
        assertEquals(0L, Solution().minimumFuelCost(arrayOf(), 1))
    }

    @Test
    fun twoCitiesOneSeatEach() {
        val roads = arrayOf(intArrayOf(0, 1))
        assertEquals(1L, Solution().minimumFuelCost(roads, 2))
    }
}
