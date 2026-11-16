package findrootofacoloredtree

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindRootOfAColoredTreeTest {
    @Test
    fun testChain() {
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2))
        assertEquals(0, Solution().findColoredRoot(edges, "RBW"))
    }

    @Test
    fun testReversedEdge() {
        val edges = arrayOf(intArrayOf(1, 0))
        assertEquals(0, Solution().findColoredRoot(edges, "RB"))
    }

    @Test
    fun testSameColor() {
        val edges = arrayOf(intArrayOf(0, 1))
        assertEquals(-1, Solution().findColoredRoot(edges, "RR"))
    }

    @Test
    fun testTooManyChildren() {
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(0, 3))
        assertEquals(-1, Solution().findColoredRoot(edges, "RBBB"))
    }

    @Test
    fun testSingleNode() {
        assertEquals(0, Solution().findColoredRoot(emptyArray(), "R"))
    }
}
