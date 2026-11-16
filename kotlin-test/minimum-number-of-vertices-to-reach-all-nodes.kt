package minimumnumberofverticestoreachallnodes

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MinimumNumberOfVerticesToReachAllNodesTest {

    @Test
    fun testExample1() {
        val edges = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(0, 2),
            intArrayOf(2, 5),
            intArrayOf(3, 4),
            intArrayOf(4, 2)
        )
        assertEquals(listOf(0, 3), Solution().findSmallestSetOfVertices(6, edges))
    }

    @Test
    fun testExample2() {
        val edges = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(2, 1),
            intArrayOf(3, 1),
            intArrayOf(1, 4),
            intArrayOf(2, 4)
        )
        assertEquals(listOf(0, 2, 3), Solution().findSmallestSetOfVertices(5, edges))
    }

    @Test
    fun testSingleNodeNoEdges() {
        assertEquals(listOf(0), Solution().findSmallestSetOfVertices(1, arrayOf()))
    }

    @Test
    fun testSingleEdge() {
        assertEquals(listOf(0), Solution().findSmallestSetOfVertices(2, arrayOf(intArrayOf(0, 1))))
    }

    @Test
    fun testChain() {
        val edges = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 2),
            intArrayOf(2, 3)
        )
        assertEquals(listOf(0), Solution().findSmallestSetOfVertices(4, edges))
    }

    @Test
    fun testAllNodesHaveIncomingEdge() {
        val edges = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 0)
        )
        assertEquals(emptyList<Int>(), Solution().findSmallestSetOfVertices(2, edges))
    }
}
