package maximumpointsaftercollectingcoinsfromallnodes

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MaximumPointsAfterCollectingCoinsFromAllNodesTest {
    @Test
    fun firstExample() {
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(2, 3))
        assertEquals(11, Solution().maximumPoints(edges, intArrayOf(10, 10, 3, 3), 5))
    }

    @Test
    fun secondExample() {
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(0, 2))
        assertEquals(16, Solution().maximumPoints(edges, intArrayOf(8, 4, 4), 0))
    }

    @Test
    fun singleNodeChoosesBetterCollectionMethod() {
        assertEquals(5, Solution().maximumPoints(emptyArray(), intArrayOf(9), 4))
        assertEquals(9, Solution().maximumPoints(emptyArray(), intArrayOf(9), 0))
    }

    @Test
    fun zeroCoins() {
        assertEquals(0, Solution().maximumPoints(arrayOf(intArrayOf(0, 1)), intArrayOf(0, 0), 1))
    }
}
