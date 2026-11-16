package removemaxnumberofedgestokeepgraphfullytraversable

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RemoveMaxNumberOfEdgesToKeepGraphFullyTraversableTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        val edges = arrayOf(
            intArrayOf(3, 1, 2),
            intArrayOf(3, 2, 3),
            intArrayOf(1, 1, 3),
            intArrayOf(1, 2, 4),
            intArrayOf(1, 1, 2),
            intArrayOf(2, 3, 4)
        )
        assertEquals(2, solution.maxNumEdgesToRemove(4, edges))
    }

    @Test
    fun testExample2() {
        val edges = arrayOf(
            intArrayOf(3, 1, 2),
            intArrayOf(3, 2, 3),
            intArrayOf(1, 1, 4),
            intArrayOf(2, 1, 4)
        )
        assertEquals(0, solution.maxNumEdgesToRemove(4, edges))
    }

    @Test
    fun testExample3() {
        val edges = arrayOf(
            intArrayOf(3, 2, 3),
            intArrayOf(1, 1, 2),
            intArrayOf(2, 3, 4)
        )
        assertEquals(-1, solution.maxNumEdgesToRemove(4, edges))
    }

    @Test
    fun testSingleNode() {
        assertEquals(0, solution.maxNumEdgesToRemove(1, arrayOf()))
    }
}
