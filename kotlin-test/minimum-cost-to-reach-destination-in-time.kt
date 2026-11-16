package minimumcosttoreachdestinationintime

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumCostToReachDestinationInTimeTest {
    private val edges = arrayOf(
        intArrayOf(0, 1, 10),
        intArrayOf(1, 2, 10),
        intArrayOf(2, 5, 10),
        intArrayOf(0, 3, 1),
        intArrayOf(3, 4, 10),
        intArrayOf(4, 5, 10)
    )
    private val fees = intArrayOf(5, 1, 2, 20, 20, 3)

    @Test
    fun example1() {
        assertEquals(11, Solution().minCost(30, edges, fees))
    }

    @Test
    fun example2() {
        assertEquals(48, Solution().minCost(29, edges, fees))
    }

    @Test
    fun tooLittleTime() {
        assertEquals(-1, Solution().minCost(20, edges, fees))
    }

    @Test
    fun directEdge() {
        assertEquals(3, Solution().minCost(10, arrayOf(intArrayOf(0, 1, 10)), intArrayOf(1, 2)))
    }

    @Test
    fun directEdgeTooSlow() {
        assertEquals(-1, Solution().minCost(9, arrayOf(intArrayOf(0, 1, 10)), intArrayOf(1, 2)))
    }
}
