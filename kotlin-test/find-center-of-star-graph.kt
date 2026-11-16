package findcenterofstargraph

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class FindCenterOfStarGraphTest {
    @Test
    fun centerAppearsInDifferentPositions() {
        val edges = arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(4, 2))
        assertEquals(2, Solution().findCenter(edges))
    }

    @Test
    fun fourLeaves() {
        val edges = arrayOf(intArrayOf(1, 2), intArrayOf(5, 1), intArrayOf(1, 3), intArrayOf(1, 4))
        assertEquals(1, Solution().findCenter(edges))
    }

    @Test
    fun centerIsSecondSharedEndpoint() {
        val edges = arrayOf(intArrayOf(3, 4), intArrayOf(5, 4), intArrayOf(4, 6))
        assertEquals(4, Solution().findCenter(edges))
    }
}
