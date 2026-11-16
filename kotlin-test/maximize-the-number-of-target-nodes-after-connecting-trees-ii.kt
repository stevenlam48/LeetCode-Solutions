package maximizethenumberoftargetnodesafterconnectingtreesii

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MaximizeTheNumberOfTargetNodesAfterConnectingTreesIITest {
    @Test
    fun exampleOne() {
        val edges1 = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(0, 2),
            intArrayOf(2, 3),
            intArrayOf(2, 4)
        )
        val edges2 = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(0, 2),
            intArrayOf(0, 3),
            intArrayOf(2, 7),
            intArrayOf(1, 4),
            intArrayOf(4, 5),
            intArrayOf(4, 6)
        )
        assertArrayEquals(intArrayOf(8, 7, 7, 8, 8), Solution().maxTargetNodes(edges1, edges2))
    }

    @Test
    fun exampleTwo() {
        val edges1 = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(0, 2),
            intArrayOf(0, 3),
            intArrayOf(0, 4)
        )
        val edges2 = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 2),
            intArrayOf(2, 3)
        )
        assertArrayEquals(intArrayOf(3, 6, 6, 6, 6), Solution().maxTargetNodes(edges1, edges2))
    }

    @Test
    fun singleEdge() {
        val edges1 = arrayOf(intArrayOf(0, 1))
        val edges2 = arrayOf(intArrayOf(0, 1))
        assertArrayEquals(intArrayOf(2, 2), Solution().maxTargetNodes(edges1, edges2))
    }
}
