package countunreachablepairsofnodesinanundirectedgraph

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountUnreachablePairsOfNodesInAnUndirectedGraphTest {
    @Test
    fun `connected graph`() {
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(0, 2))

        assertEquals(0L, Solution().countPairs(3, edges))
    }

    @Test
    fun `three disconnected components`() {
        val edges = arrayOf(
            intArrayOf(0, 2),
            intArrayOf(0, 5),
            intArrayOf(2, 4),
            intArrayOf(1, 6),
            intArrayOf(5, 4)
        )

        assertEquals(14L, Solution().countPairs(7, edges))
    }

    @Test
    fun `no nodes`() {
        assertEquals(0L, Solution().countPairs(0, emptyArray()))
    }

    @Test
    fun `all nodes isolated`() {
        assertEquals(6L, Solution().countPairs(4, emptyArray()))
    }

    @Test
    fun `components of unequal sizes`() {
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(2, 3))

        assertEquals(8L, Solution().countPairs(5, edges))
    }
}
