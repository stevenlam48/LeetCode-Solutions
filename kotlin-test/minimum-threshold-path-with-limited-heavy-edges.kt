package minimumthresholdpathwithlimitedheavyedges

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MinimumThresholdPathWithLimitedHeavyEdgesTest {
    private val solution = Solution()

    @Test
    fun testPathGraph() {
        val edges = arrayOf(
            intArrayOf(0, 1, 1),
            intArrayOf(1, 2, 2),
            intArrayOf(2, 3, 3)
        )
        assertEquals(2, solution.minimumThreshold(4, edges, 0, 3, 1))
        assertEquals(1, solution.minimumThreshold(4, edges, 0, 3, 2))
        assertEquals(0, solution.minimumThreshold(4, edges, 0, 3, 3))
    }

    @Test
    fun testTwoPossiblePaths() {
        val edges = arrayOf(
            intArrayOf(0, 1, 5),
            intArrayOf(1, 2, 1),
            intArrayOf(0, 2, 3)
        )
        assertEquals(3, solution.minimumThreshold(3, edges, 0, 2, 0))
        assertEquals(0, solution.minimumThreshold(3, edges, 0, 2, 1))
    }

    @Test
    fun testDisconnected() {
        val edges = arrayOf(intArrayOf(0, 1, 1))
        assertEquals(-1, solution.minimumThreshold(3, edges, 0, 2, 1))
        assertEquals(-1, solution.minimumThreshold(2, emptyArray(), 0, 1, 0))
    }

    @Test
    fun testUniformWeights() {
        val edges = arrayOf(
            intArrayOf(0, 1, 4),
            intArrayOf(1, 2, 4),
            intArrayOf(2, 3, 4)
        )
        assertEquals(4, solution.minimumThreshold(4, edges, 0, 3, 0))
        assertEquals(4, solution.minimumThreshold(4, edges, 0, 3, 1))
    }
}
