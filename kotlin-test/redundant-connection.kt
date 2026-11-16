package redundantconnection

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RedundantConnectionTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        val edges = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(1, 3),
            intArrayOf(2, 3)
        )
        assertArrayEquals(intArrayOf(2, 3), solution.findRedundantConnection(edges))
    }

    @Test
    fun testExample2() {
        val edges = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(3, 4),
            intArrayOf(1, 4),
            intArrayOf(1, 5)
        )
        assertArrayEquals(intArrayOf(1, 4), solution.findRedundantConnection(edges))
    }

    @Test
    fun testTriangle() {
        val edges = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(3, 1)
        )
        assertArrayEquals(intArrayOf(3, 1), solution.findRedundantConnection(edges))
    }

    @Test
    fun testTwoNodes() {
        val edges = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(1, 2)
        )
        assertArrayEquals(intArrayOf(1, 2), solution.findRedundantConnection(edges))
    }

    @Test
    fun testLastEdgeRedundant() {
        val edges = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(3, 4),
            intArrayOf(4, 5),
            intArrayOf(5, 1)
        )
        assertArrayEquals(intArrayOf(5, 1), solution.findRedundantConnection(edges))
    }

    @Test
    fun testStarWithExtraEdge() {
        val edges = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(1, 3),
            intArrayOf(1, 4),
            intArrayOf(2, 4)
        )
        assertArrayEquals(intArrayOf(2, 4), solution.findRedundantConnection(edges))
    }
}
