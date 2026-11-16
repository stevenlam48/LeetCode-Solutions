package nodewithhighestedgescore

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NodeWithHighestEdgeScoreTest {
    @Test
    fun example1() {
        assertEquals(7, Solution().edgeScore(intArrayOf(1, 0, 0, 0, 0, 7, 7, 5)))
    }

    @Test
    fun tieReturnsSmallestIndex() {
        assertEquals(0, Solution().edgeScore(intArrayOf(2, 0, 0, 2)))
    }

    @Test
    fun singleNode() {
        assertEquals(0, Solution().edgeScore(intArrayOf(0)))
    }

    @Test
    fun allEdgesToSameNode() {
        assertEquals(1, Solution().edgeScore(intArrayOf(1, 1, 1)))
    }

    @Test
    fun accumulatedScore() {
        assertEquals(0, Solution().edgeScore(intArrayOf(1, 0, 2, 0)))
    }
}
