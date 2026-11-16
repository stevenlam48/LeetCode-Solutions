package pythagoreandistancenodesinatree

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PythagoreanDistanceNodesInATreeTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        val edges = arrayOf(
            intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(0, 3), intArrayOf(1, 4)
        )
        assertEquals(1, solution.specialNodes(5, edges, 2, 3, 4))
    }

    @Test
    fun testPath() {
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2))
        assertEquals(1, solution.specialNodes(3, edges, 0, 1, 2))
    }

    @Test
    fun testSingleNode() {
        assertEquals(1, solution.specialNodes(1, arrayOf(), 0, 0, 0))
    }

    @Test
    fun testStar() {
        val edges = arrayOf(
            intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(0, 3), intArrayOf(0, 4)
        )
        assertEquals(3, solution.specialNodes(5, edges, 1, 2, 3))
    }
}
