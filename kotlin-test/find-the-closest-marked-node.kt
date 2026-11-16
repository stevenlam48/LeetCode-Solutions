package findtheclosestmarkednode

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class FindTheClosestMarkedNodeTest {
    @Test
    fun findsShortestPathToMarkedNode() {
        val edges = arrayOf(intArrayOf(0, 1, 1), intArrayOf(1, 2, 2), intArrayOf(0, 2, 4))
        assertEquals(3, Solution().minimumDistance(4, edges, 0, intArrayOf(2)))
    }

    @Test
    fun returnsZeroWhenStartIsMarked() {
        val edges = arrayOf(intArrayOf(0, 1, 7))
        assertEquals(0, Solution().minimumDistance(2, edges, 0, intArrayOf(0, 1)))
    }

    @Test
    fun returnsMinusOneWhenNoMarkedNodeIsReachable() {
        val edges = arrayOf(intArrayOf(0, 1, 2), intArrayOf(2, 3, 3))
        assertEquals(-1, Solution().minimumDistance(4, edges, 0, intArrayOf(3)))
    }

    @Test
    fun choosesClosestAmongSeveralMarkedNodes() {
        val edges = arrayOf(intArrayOf(0, 1, 5), intArrayOf(0, 2, 1), intArrayOf(2, 3, 1))
        assertEquals(2, Solution().minimumDistance(4, edges, 0, intArrayOf(1, 3, 3)))
    }
}
