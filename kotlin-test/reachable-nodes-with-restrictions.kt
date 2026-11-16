package reachablenodeswithrestrictions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class ReachableNodesWithRestrictionsTest {
    @Test
    fun leetCodeExample() {
        assertEquals(4, Solution().reachableNodes(
            7,
            arrayOf(
                intArrayOf(0, 1),
                intArrayOf(1, 2),
                intArrayOf(3, 1),
                intArrayOf(4, 0),
                intArrayOf(0, 5),
                intArrayOf(5, 6)
            ),
            intArrayOf(4, 5)
        ))
    }

    @Test
    fun restrictionsPruneEntireBranches() {
        assertEquals(3, Solution().reachableNodes(
            7,
            arrayOf(
                intArrayOf(0, 1),
                intArrayOf(0, 2),
                intArrayOf(2, 3),
                intArrayOf(2, 4),
                intArrayOf(3, 5),
                intArrayOf(5, 6)
            ),
            intArrayOf(1, 3, 6)
        ))
    }

    @Test
    fun singleNodeAndDisconnectedTree() {
        assertEquals(1, Solution().reachableNodes(1, emptyArray(), intArrayOf()))
        assertEquals(2, Solution().reachableNodes(
            4,
            arrayOf(intArrayOf(0, 1), intArrayOf(2, 3)),
            intArrayOf()
        ))
    }
}
