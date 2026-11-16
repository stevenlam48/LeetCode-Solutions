package distancetoacycleinundirectedgraph

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class DistanceToACycleInUndirectedGraphTest {
    @Test
    fun testExample1() {
        val edges = arrayOf(
            intArrayOf(1, 2), intArrayOf(2, 4), intArrayOf(4, 3),
            intArrayOf(3, 1), intArrayOf(0, 1), intArrayOf(5, 2),
            intArrayOf(6, 5)
        )
        assertArrayEquals(intArrayOf(1, 0, 0, 0, 0, 1, 2), Solution().distanceToCycle(7, edges))
    }

    @Test
    fun testTriangleWithTail() {
        val edges = arrayOf(
            intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(2, 0), intArrayOf(2, 3)
        )
        assertArrayEquals(intArrayOf(0, 0, 0, 1), Solution().distanceToCycle(4, edges))
    }

    @Test
    fun testPureCycle() {
        val edges = arrayOf(
            intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3, 0)
        )
        assertArrayEquals(intArrayOf(0, 0, 0, 0), Solution().distanceToCycle(4, edges))
    }

    @Test
    fun testLongTail() {
        val edges = arrayOf(
            intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(2, 0),
            intArrayOf(2, 3), intArrayOf(3, 4)
        )
        assertArrayEquals(intArrayOf(0, 0, 0, 1, 2), Solution().distanceToCycle(5, edges))
    }
}
