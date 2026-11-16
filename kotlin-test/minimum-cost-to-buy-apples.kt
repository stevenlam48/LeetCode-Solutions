package minimumcosttobuyapples

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MinimumCostToBuyApplesTest {
    @Test
    fun standardExample() {
        assertArrayEquals(
            longArrayOf(54, 42, 48, 51),
            Solution().minCost(
                4,
                arrayOf(
                    intArrayOf(1, 2, 4), intArrayOf(2, 3, 2), intArrayOf(2, 4, 5),
                    intArrayOf(3, 4, 1), intArrayOf(1, 3, 4)
                ),
                intArrayOf(56, 42, 102, 301),
                2
            )
        )
    }

    @Test
    fun singleCity() {
        assertArrayEquals(longArrayOf(5), Solution().minCost(1, arrayOf(), intArrayOf(5), 1))
    }

    @Test
    fun cheaperToBuyElsewhere() {
        assertArrayEquals(
            longArrayOf(21, 1),
            Solution().minCost(2, arrayOf(intArrayOf(1, 2, 10)), intArrayOf(100, 1), 1)
        )
    }
}
