package maximumpathqualityofagraph

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MaximumPathQualityOfAGraphTest {
    @Test
    fun firstExample() {
        val edges = arrayOf(intArrayOf(0, 1, 10), intArrayOf(1, 2, 15), intArrayOf(0, 3, 10))
        assertEquals(75, Solution().maximalPathQuality(intArrayOf(0, 32, 10, 43), edges, 49))
    }

    @Test
    fun secondExample() {
        val edges = arrayOf(intArrayOf(0, 1, 10), intArrayOf(1, 2, 10), intArrayOf(0, 3, 10))
        assertEquals(25, Solution().maximalPathQuality(intArrayOf(5, 10, 15, 20), edges, 30))
    }

    @Test
    fun thirdExample() {
        val edges = arrayOf(intArrayOf(0, 1, 10), intArrayOf(1, 2, 11), intArrayOf(2, 3, 12), intArrayOf(1, 3, 13))
        assertEquals(7, Solution().maximalPathQuality(intArrayOf(1, 2, 3, 4), edges, 50))
    }

    @Test
    fun singleNode() {
        assertEquals(7, Solution().maximalPathQuality(intArrayOf(7), emptyArray(), 0))
    }
}
