package reachablenodesinsubdividedgraph
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class ReachableNodesInSubdividedGraphTest {
    @Test
    fun firstLeetCodeExample() {
        assertEquals(13, Solution().reachableNodes(
            arrayOf(intArrayOf(0, 1, 10), intArrayOf(0, 2, 1), intArrayOf(1, 2, 2)),
            6,
            3
        ))
    }

    @Test
    fun secondLeetCodeExample() {
        assertEquals(25, Solution().reachableNodes(
            arrayOf(
                intArrayOf(0, 1, 4),
                intArrayOf(1, 2, 6),
                intArrayOf(0, 2, 8),
                intArrayOf(0, 3, 3)
            ),
            10,
            4
        ))
    }

    @Test
    fun noMovesOrNoEdges() {
        assertEquals(1, Solution().reachableNodes(emptyArray(), 0, 1))
        assertEquals(1, Solution().reachableNodes(emptyArray(), 5, 4))
        assertEquals(1, Solution().reachableNodes(arrayOf(intArrayOf(0, 1, 3)), 0, 2))
    }

    @Test
    fun partialEdgesCanBeReachedFromBothEnds() {
        assertEquals(4, Solution().reachableNodes(arrayOf(intArrayOf(0, 1, 5)), 3, 2))
        assertEquals(2, Solution().reachableNodes(arrayOf(intArrayOf(0, 1, 3)), 1, 2))
    }
}
