package minimumweightedsubgraphwiththerequiredpaths

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MinimumWeightedSubgraphWithTheRequiredPathsTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        val edges = arrayOf(
            intArrayOf(0, 2, 2), intArrayOf(0, 5, 6), intArrayOf(1, 3, 3),
            intArrayOf(1, 5, 3), intArrayOf(2, 3, 1), intArrayOf(3, 5, 1),
            intArrayOf(4, 5, 2)
        )
        assertEquals(7L, solution.minimumWeight(6, edges, 0, 1, 5))
    }

    @Test
    fun testExample2() {
        val edges = arrayOf(
            intArrayOf(0, 1, 1), intArrayOf(1, 2, 1), intArrayOf(0, 2, 3)
        )
        assertEquals(2L, solution.minimumWeight(3, edges, 0, 1, 2))
    }

    @Test
    fun testExample3() {
        val edges = arrayOf(
            intArrayOf(0, 1, 1), intArrayOf(1, 2, 1), intArrayOf(0, 2, 3),
            intArrayOf(3, 4, 1)
        )
        assertEquals(-1L, solution.minimumWeight(5, edges, 0, 1, 4))
    }

    @Test
    fun testDirectEdge() {
        val edges = arrayOf(intArrayOf(0, 1, 5))
        assertEquals(5L, solution.minimumWeight(2, edges, 0, 0, 1))
    }
}
