package minimumcosttobuyapplesii

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MinimumCostToBuyApplesIITest {
    @Test
    fun singleCity() {
        assertArrayEquals(intArrayOf(5), Solution().minCost(1, intArrayOf(5), arrayOf()))
    }

    @Test
    fun roundTripWithMultiplierOne() {
        assertArrayEquals(
            intArrayOf(3, 7),
            Solution().minCost(2, intArrayOf(3, 10), arrayOf(intArrayOf(0, 1, 2, 1)))
        )
    }

    @Test
    fun cheaperNeighborWithExpensiveReturn() {
        assertArrayEquals(
            intArrayOf(31, 1),
            Solution().minCost(2, intArrayOf(100, 1), arrayOf(intArrayOf(0, 1, 10, 2)))
        )
    }

    @Test
    fun threeCities() {
        assertArrayEquals(
            intArrayOf(3, 1, 7),
            Solution().minCost(
                3,
                intArrayOf(4, 1, 20),
                arrayOf(intArrayOf(0, 1, 1, 1), intArrayOf(1, 2, 3, 1))
            )
        )
    }
}
