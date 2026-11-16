package modifygraphedgeweights

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ModifyGraphEdgeWeightsTest {
    private val solution = Solution()

    @Test
    fun modifiesEdgesToReachTarget() {
        val edges = arrayOf(
            intArrayOf(4, 1, -1),
            intArrayOf(2, 0, -1),
            intArrayOf(0, 3, -1),
            intArrayOf(4, 3, -1)
        )
        val actual = solution.modifiedGraphEdges(5, edges, 0, 1, 5)
        val expected = arrayOf(
            intArrayOf(4, 1, 3),
            intArrayOf(2, 0, 1),
            intArrayOf(0, 3, 1),
            intArrayOf(4, 3, 1)
        )
        assertTrue(expected.contentDeepEquals(actual))
    }

    @Test
    fun distributesRequiredWeightAcrossEditableEdges() {
        val edges = arrayOf(intArrayOf(0, 1, -1), intArrayOf(1, 2, -1))
        val actual = solution.modifiedGraphEdges(3, edges, 0, 2, 5)
        assertTrue(arrayOf(intArrayOf(0, 1, 1), intArrayOf(1, 2, 4)).contentDeepEquals(actual))
    }

    @Test
    fun leavesFixedGraphUnchangedWhenTargetMatches() {
        val edges = arrayOf(intArrayOf(0, 1, 2), intArrayOf(1, 2, 3))
        val actual = solution.modifiedGraphEdges(3, edges, 0, 2, 5)
        assertTrue(edges.contentDeepEquals(actual))
        assertArrayEquals(intArrayOf(0, 1, 2), actual[0])
        assertArrayEquals(intArrayOf(1, 2, 3), actual[1])
    }

    @Test
    fun returnsEmptyWhenTargetIsImpossible() {
        val edges = arrayOf(intArrayOf(0, 1, 1), intArrayOf(1, 2, 1), intArrayOf(0, 2, 4))
        assertTrue(solution.modifiedGraphEdges(3, edges, 0, 2, 1).isEmpty())
    }
}
