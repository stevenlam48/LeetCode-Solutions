package shortestpathwithatmostkconsecutiveidenticalcharacters

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ShortestPathWithAtMostKConsecutiveIdenticalCharactersTest {
    @Test
    fun takesDirectEdgeWithDifferentLabels() {
        val edges = arrayOf(intArrayOf(0, 1, 1))
        assertEquals(1, Solution().shortestPath(2, edges, "ab", 1))
    }

    @Test
    fun blocksPathWhenLabelsMatchTooOften() {
        val edges = arrayOf(intArrayOf(0, 1, 1))
        assertEquals(-1, Solution().shortestPath(2, edges, "aa", 1))
    }

    @Test
    fun allowsThreeConsecutiveIdenticalLabels() {
        val edges = arrayOf(intArrayOf(0, 1, 1), intArrayOf(1, 2, 1))
        assertEquals(-1, Solution().shortestPath(3, edges, "aaa", 1))
        assertEquals(-1, Solution().shortestPath(3, edges, "aaa", 2))
        assertEquals(2, Solution().shortestPath(3, edges, "aaa", 3))
    }

    @Test
    fun prefersLongerPathWithFewerRepeats() {
        val edges = arrayOf(
            intArrayOf(0, 1, 10),
            intArrayOf(0, 2, 1),
            intArrayOf(2, 1, 1),
            intArrayOf(1, 3, 1)
        )
        assertEquals(3, Solution().shortestPath(4, edges, "aabc", 1))
        assertEquals(3, Solution().shortestPath(4, edges, "aabc", 2))
    }

    @Test
    fun handlesUnreachableTarget() {
        val edges = arrayOf(intArrayOf(0, 1, 1))
        assertEquals(-1, Solution().shortestPath(3, edges, "abc", 1))
    }
}
