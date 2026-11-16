package allancestorsofanodeinadirectedacyclicgraph

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class AllAncestorsOfANodeInADirectedAcyclicGraphTest {
    private fun assertAncestors(expected: List<List<Int>>, actual: List<List<Int>>) {
        assertEquals(expected, actual.map { it.sorted() })
    }

    @Test
    fun testExample1() {
        val n = 8
        val edges = arrayOf(
            intArrayOf(0, 3), intArrayOf(0, 4), intArrayOf(1, 3), intArrayOf(2, 4),
            intArrayOf(2, 7), intArrayOf(3, 5), intArrayOf(3, 6), intArrayOf(3, 7),
            intArrayOf(4, 6)
        )
        val expected = listOf(
            listOf(), listOf(), listOf(), listOf(0, 1), listOf(0, 2),
            listOf(0, 1, 3), listOf(0, 1, 2, 3, 4), listOf(0, 1, 2, 3)
        )
        assertAncestors(expected, Solution().getAncestors(n, edges))
    }

    @Test
    fun testExample2() {
        val n = 5
        val edges = arrayOf(
            intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(0, 3), intArrayOf(0, 4),
            intArrayOf(1, 2), intArrayOf(1, 3), intArrayOf(1, 4), intArrayOf(2, 3),
            intArrayOf(2, 4), intArrayOf(3, 4)
        )
        val expected = listOf(
            listOf(), listOf(0), listOf(0, 1), listOf(0, 1, 2), listOf(0, 1, 2, 3)
        )
        assertAncestors(expected, Solution().getAncestors(n, edges))
    }

    @Test
    fun testSingleNode() {
        assertAncestors(listOf(listOf()), Solution().getAncestors(1, arrayOf()))
    }
}
