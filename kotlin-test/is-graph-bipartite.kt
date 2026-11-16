package isgraphbipartite

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class IsGraphBipartiteTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        val graph = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(0, 2),
            intArrayOf(0, 1, 3),
            intArrayOf(0, 2)
        )
        assertFalse(solution.isBipartite(graph))
    }

    @Test
    fun testExample2() {
        val graph = arrayOf(
            intArrayOf(1, 3),
            intArrayOf(0, 2),
            intArrayOf(1, 3),
            intArrayOf(0, 2)
        )
        assertTrue(solution.isBipartite(graph))
    }

    @Test
    fun testTriangle() {
        val graph = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(0, 2),
            intArrayOf(0, 1)
        )
        assertFalse(solution.isBipartite(graph))
    }

    @Test
    fun testDisconnected() {
        val graph = arrayOf(
            intArrayOf(),
            intArrayOf(2),
            intArrayOf(1)
        )
        assertTrue(solution.isBipartite(graph))
    }

    @Test
    fun testEmptyGraph() {
        assertTrue(solution.isBipartite(emptyArray()))
    }
}
