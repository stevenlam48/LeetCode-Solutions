package maximumcoincollection

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumCoinCollectionTest {
    @Test
    fun example() {
        assertEquals(15L, Solution().maxCoins(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6)))
    }

    @Test
    fun weavesBetweenLanes() {
        assertEquals(15L, Solution().maxCoins(intArrayOf(5, -10, 5), intArrayOf(-10, 5, -10)))
    }

    @Test
    fun singleColumn() {
        assertEquals(2L, Solution().maxCoins(intArrayOf(1), intArrayOf(2)))
    }

    @Test
    fun allNegative() {
        assertEquals(-5L, Solution().maxCoins(intArrayOf(-5, -5), intArrayOf(-5, -5)))
    }
}
