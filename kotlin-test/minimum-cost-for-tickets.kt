package minimumcostfortickets

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumCostForTicketsTest {
    @Test
    fun standardExamples() {
        assertEquals(11, Solution().mincostTickets(intArrayOf(1, 4, 6, 7, 8, 20), intArrayOf(2, 7, 15)))
        assertEquals(17, Solution().mincostTickets(
            intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31), intArrayOf(2, 7, 15)
        ))
    }

    @Test
    fun singleDay() {
        assertEquals(10, Solution().mincostTickets(intArrayOf(5), intArrayOf(10, 20, 50)))
    }

    @Test
    fun twoDistantDays() {
        assertEquals(4, Solution().mincostTickets(intArrayOf(1, 365), intArrayOf(2, 7, 15)))
    }
}
