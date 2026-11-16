package countthenumberofgoodnodes

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CountTheNumberOfGoodNodesTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        val edges = arrayOf(
            intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(1, 3),
            intArrayOf(1, 4), intArrayOf(2, 5), intArrayOf(2, 6)
        )
        assertEquals(7, solution.countGoodNodes(edges))
    }

    @Test
    fun testExample2() {
        val edges = arrayOf(
            intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3, 4),
            intArrayOf(0, 5), intArrayOf(1, 6), intArrayOf(2, 7), intArrayOf(3, 8)
        )
        assertEquals(6, solution.countGoodNodes(edges))
    }

    @Test
    fun testSingleNode() {
        assertEquals(1, solution.countGoodNodes(arrayOf()))
    }

    @Test
    fun testTwoNodes() {
        assertEquals(2, solution.countGoodNodes(arrayOf(intArrayOf(0, 1))))
    }

    @Test
    fun testUnbalanced() {
        val edges = arrayOf(
            intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(2, 3)
        )
        assertEquals(4, solution.countGoodNodes(edges))
    }
}
