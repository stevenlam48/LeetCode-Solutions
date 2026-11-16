package redundantconnectionii

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class RedundantConnectionIiTest {
    @Test
    fun twoParents() {
        val edges = arrayOf(intArrayOf(1, 2), intArrayOf(1, 3), intArrayOf(2, 3))
        assertArrayEquals(intArrayOf(2, 3), Solution().findRedundantDirectedConnection(edges))
    }

    @Test
    fun cyclePrecedesSecondParent() {
        val edges = arrayOf(
            intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3, 4),
            intArrayOf(4, 1), intArrayOf(1, 5)
        )
        assertArrayEquals(intArrayOf(4, 1), Solution().findRedundantDirectedConnection(edges))
    }

    @Test
    fun removingSecondCandidateLeavesCycle() {
        val edges = arrayOf(intArrayOf(2, 1), intArrayOf(3, 1), intArrayOf(4, 2), intArrayOf(1, 4))
        assertArrayEquals(intArrayOf(2, 1), Solution().findRedundantDirectedConnection(edges))
    }

    @Test
    fun cycleWithoutSecondParent() {
        val edges = arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3, 1))
        assertArrayEquals(intArrayOf(3, 1), Solution().findRedundantDirectedConnection(edges))
    }
}
