package numberofrestrictedpathsfromfirsttolastnode

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class NumberOfRestrictedPathsFromFirstToLastNodeTest {
    @Test
    fun testExample1() {
        val edges = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(1, 3, 3),
            intArrayOf(2, 3, 1),
            intArrayOf(1, 4, 2),
            intArrayOf(5, 2, 2),
            intArrayOf(3, 5, 1),
            intArrayOf(5, 4, 10)
        )
        assertEquals(3, Solution().countRestrictedPaths(5, edges))
    }

    @Test
    fun testSingleEdge() {
        assertEquals(1, Solution().countRestrictedPaths(2, arrayOf(intArrayOf(1, 2, 5))))
    }

    @Test
    fun testDiamond() {
        val edges = arrayOf(
            intArrayOf(1, 2, 1),
            intArrayOf(2, 4, 1),
            intArrayOf(1, 3, 1),
            intArrayOf(3, 4, 1)
        )
        assertEquals(2, Solution().countRestrictedPaths(4, edges))
    }
}
