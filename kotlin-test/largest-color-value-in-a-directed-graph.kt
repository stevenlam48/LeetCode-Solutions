package largestcolorvalueinadirectedgraph

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LargestColorValueInADirectedGraphTest {
    @Test
    fun repeatedColorOnLongestValuePath() {
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(2, 3), intArrayOf(3, 4))
        assertEquals(3, Solution().largestPathValue("abaca", edges))
    }

    @Test
    fun cycleReturnsMinusOne() {
        assertEquals(-1, Solution().largestPathValue("a", arrayOf(intArrayOf(0, 0))))
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(1, 0))
        assertEquals(-1, Solution().largestPathValue("ab", edges))
    }

    @Test
    fun disconnectedPaths() {
        val edges = arrayOf(intArrayOf(0, 2), intArrayOf(1, 3))
        assertEquals(1, Solution().largestPathValue("aabb", edges))
    }

    @Test
    fun noEdges() {
        assertEquals(1, Solution().largestPathValue("zzz", emptyArray()))
    }
}
