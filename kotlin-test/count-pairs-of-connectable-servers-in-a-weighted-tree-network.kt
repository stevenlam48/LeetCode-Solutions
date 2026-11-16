package countpairsofconnectableserversinaweightedtreenetwork

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CountPairsOfConnectableServersInAWeightedTreeNetworkTest {
    private val solution = Solution()

    @Test
    fun testPath() {
        val edges = arrayOf(intArrayOf(0, 1, 1), intArrayOf(1, 2, 1))
        assertArrayEquals(intArrayOf(0, 1, 0), solution.countPairsOfConnectableServers(edges, 1))
    }

    @Test
    fun testPathNotDivisible() {
        val edges = arrayOf(intArrayOf(0, 1, 1), intArrayOf(1, 2, 1))
        assertArrayEquals(intArrayOf(0, 0, 0), solution.countPairsOfConnectableServers(edges, 2))
    }

    @Test
    fun testStar() {
        val edges = arrayOf(intArrayOf(0, 1, 2), intArrayOf(0, 2, 2), intArrayOf(0, 3, 2))
        assertArrayEquals(intArrayOf(3, 0, 0, 0), solution.countPairsOfConnectableServers(edges, 2))
    }

    @Test
    fun testStarOneBranchExcluded() {
        val edges = arrayOf(intArrayOf(0, 1, 3), intArrayOf(0, 2, 3), intArrayOf(0, 3, 4))
        assertArrayEquals(intArrayOf(1, 0, 0, 0), solution.countPairsOfConnectableServers(edges, 3))
    }

    @Test
    fun testSingleEdge() {
        val edges = arrayOf(intArrayOf(0, 1, 1))
        assertArrayEquals(intArrayOf(0, 0), solution.countPairsOfConnectableServers(edges, 1))
    }
}
