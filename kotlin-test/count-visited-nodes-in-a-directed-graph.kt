package countvisitednodesinadirectedgraph

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class CountVisitedNodesInADirectedGraphTest {
    @Test
    fun threeCycle() {
        assertArrayEquals(intArrayOf(3, 3, 3), Solution().countVisitedNodes(intArrayOf(1, 2, 0)))
    }

    @Test
    fun treeFeedingCycle() {
        assertArrayEquals(intArrayOf(3, 3, 3, 4), Solution().countVisitedNodes(intArrayOf(1, 2, 0, 2)))
    }

    @Test
    fun multipleCycles() {
        assertArrayEquals(
            intArrayOf(3, 3, 3, 4, 4, 4, 4, 3, 3, 3),
            Solution().countVisitedNodes(intArrayOf(1, 2, 0, 4, 5, 6, 3, 8, 9, 7))
        )
    }

    @Test
    fun chainIntoSelfLoop() {
        assertArrayEquals(intArrayOf(2, 1), Solution().countVisitedNodes(intArrayOf(1, 1)))
    }

    @Test
    fun selfLoopOnly() {
        assertArrayEquals(intArrayOf(1), Solution().countVisitedNodes(intArrayOf(0)))
    }
}
