package minimumcosttoreacheveryposition

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MinimumCostToReachEveryPositionTest {
    @Test
    fun example1() {
        assertArrayEquals(intArrayOf(5, 3, 3, 1, 1, 1), Solution().minCosts(intArrayOf(5, 3, 4, 1, 3, 2)))
    }

    @Test
    fun single() {
        assertArrayEquals(intArrayOf(1), Solution().minCosts(intArrayOf(1)))
    }

    @Test
    fun decreasing() {
        assertArrayEquals(intArrayOf(3, 1, 1), Solution().minCosts(intArrayOf(3, 1, 2)))
    }

    @Test
    fun equal() {
        assertArrayEquals(intArrayOf(2, 2, 2), Solution().minCosts(intArrayOf(2, 2, 2)))
    }
}
