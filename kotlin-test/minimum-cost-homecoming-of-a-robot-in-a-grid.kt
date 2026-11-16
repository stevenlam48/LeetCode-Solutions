package minimumcosthomecomingofarobotinagrid

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumCostHomecomingOfARobotInAGridTest {
    @Test
    fun standardExample() {
        assertEquals(18, Solution().minCost(
            intArrayOf(1, 0), intArrayOf(2, 3),
            intArrayOf(5, 4, 3), intArrayOf(8, 2, 6, 7)
        ))
    }

    @Test
    fun alreadyHome() {
        assertEquals(0, Solution().minCost(
            intArrayOf(0, 0), intArrayOf(0, 0),
            intArrayOf(5), intArrayOf(5)
        ))
    }

    @Test
    fun onlyColumnMovement() {
        assertEquals(2, Solution().minCost(
            intArrayOf(0, 0), intArrayOf(0, 1),
            intArrayOf(1), intArrayOf(1, 2)
        ))
    }

    @Test
    fun reverseDirectionMovement() {
        assertEquals(6, Solution().minCost(
            intArrayOf(2, 2), intArrayOf(0, 0),
            intArrayOf(1, 2, 3), intArrayOf(1, 2, 3)
        ))
    }
}
