package allpathsfromsourceleadtodestination

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class AllPathsFromSourceLeadToDestinationTest {
    @Test
    fun testExample1() {
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(0, 2))
        assertFalse(Solution().leadsToDestination(3, edges, 0, 2))
    }

    @Test
    fun testExample2() {
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(0, 3), intArrayOf(1, 2), intArrayOf(2, 1))
        assertFalse(Solution().leadsToDestination(4, edges, 0, 3))
    }

    @Test
    fun testExample3() {
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(1, 3), intArrayOf(2, 3))
        assertTrue(Solution().leadsToDestination(4, edges, 0, 3))
    }

    @Test
    fun testSourceIsDestinationWithSelfLoop() {
        val edges = arrayOf(intArrayOf(0, 0))
        assertFalse(Solution().leadsToDestination(1, edges, 0, 0))
    }

    @Test
    fun testSingleNode() {
        assertTrue(Solution().leadsToDestination(1, arrayOf(), 0, 0))
    }

    @Test
    fun testDeadEnd() {
        val edges = arrayOf(intArrayOf(0, 1))
        assertTrue(Solution().leadsToDestination(2, edges, 0, 1))
        assertFalse(Solution().leadsToDestination(3, arrayOf(intArrayOf(0, 1)), 0, 2))
    }
}
