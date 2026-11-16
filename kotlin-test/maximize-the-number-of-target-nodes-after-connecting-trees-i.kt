package maximizethenumberoftargetnodesafterconnectingtreesi

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MaximizeTheNumberOfTargetNodesAfterConnectingTreesITest {
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
        assertArrayEquals(intArrayOf(9, 7, 9, 8, 8), Solution().maxTargetNodes(edges1, edges2, 2))
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
        assertArrayEquals(intArrayOf(6, 3, 3, 3, 3), Solution().maxTargetNodes(edges1, edges2, 1))
    }

    @Test
    fun kEqualsZero() {
        val edges1 = arrayOf(intArrayOf(0, 1))
        val edges2 = arrayOf(intArrayOf(0, 1))
        assertArrayEquals(intArrayOf(1, 1), Solution().maxTargetNodes(edges1, edges2, 0))
    }
}
