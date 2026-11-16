package twocityscheduling

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TwoCitySchedulingTest {
    @Test
    fun example1() {
        val costs = arrayOf(
            intArrayOf(10, 20),
            intArrayOf(30, 200),
            intArrayOf(400, 50),
            intArrayOf(30, 20)
        )
        assertEquals(110, Solution().twoCitySchedCost(costs))
    }

    @Test
    fun example2() {
        val costs = arrayOf(
            intArrayOf(259, 770),
            intArrayOf(448, 54),
            intArrayOf(926, 667),
            intArrayOf(184, 139),
            intArrayOf(840, 118),
            intArrayOf(577, 469)
        )
        assertEquals(1859, Solution().twoCitySchedCost(costs))
    }

    @Test
    fun allEqual() {
        val costs = arrayOf(intArrayOf(0, 0), intArrayOf(0, 0))
        assertEquals(0, Solution().twoCitySchedCost(costs))
    }
}
