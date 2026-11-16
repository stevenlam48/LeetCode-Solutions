package minimumnumberofrefuelingstops

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumNumberOfRefuelingStopsTest {
    private val solution = Solution()

    @Test
    fun leetCodeExample() {
        assertEquals(
            2,
            solution.minRefuelStops(
                100,
                10,
                arrayOf(intArrayOf(10, 60), intArrayOf(20, 30), intArrayOf(30, 30), intArrayOf(60, 40))
            )
        )
    }

    @Test
    fun reachesTargetWithoutStations() {
        assertEquals(0, solution.minRefuelStops(1, 1, emptyArray()))
    }

    @Test
    fun unreachableLeetCodeExample() {
        assertEquals(-1, solution.minRefuelStops(100, 1, arrayOf(intArrayOf(10, 100))))
    }

    @Test
    fun usesOneRefuelingStop() {
        assertEquals(1, solution.minRefuelStops(100, 50, arrayOf(intArrayOf(50, 50))))
    }

    @Test
    fun cannotUseFuelFromAnUnreachableStation() {
        assertEquals(-1, solution.minRefuelStops(100, 5, arrayOf(intArrayOf(10, 100))))
    }
}
