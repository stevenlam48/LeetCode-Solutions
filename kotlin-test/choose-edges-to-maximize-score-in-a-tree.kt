package chooseedgestomaximizescoreinatree

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ChooseEdgesToMaximizeScoreInATreeTest {
    private val solution = Solution()

    @Test
    fun testSingleEdge() {
        val edges = arrayOf(
            intArrayOf(-1, -1),
            intArrayOf(0, 7)
        )
        assertEquals(7L, solution.maxScore(edges))
    }

    @Test
    fun testTwoChildrenPickBest() {
        val edges = arrayOf(
            intArrayOf(-1, -1),
            intArrayOf(0, 5),
            intArrayOf(0, 10)
        )
        assertEquals(10L, solution.maxScore(edges))
    }

    @Test
    fun testChain() {
        val edges = arrayOf(
            intArrayOf(-1, -1),
            intArrayOf(0, 3),
            intArrayOf(1, 4)
        )
        assertEquals(4L, solution.maxScore(edges))
    }

    @Test
    fun testFiveNodes() {
        val edges = arrayOf(
            intArrayOf(-1, -1),
            intArrayOf(0, 5),
            intArrayOf(0, 10),
            intArrayOf(2, 6),
            intArrayOf(2, 4)
        )
        assertEquals(11L, solution.maxScore(edges))
    }

    @Test
    fun testSingleNode() {
        val edges = arrayOf(intArrayOf(-1, -1))
        assertEquals(0L, solution.maxScore(edges))
    }
}
