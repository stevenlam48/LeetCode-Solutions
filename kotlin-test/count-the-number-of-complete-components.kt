package countthenumberofcompletecomponents

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CountTheNumberOfCompleteComponentsTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        val edges = arrayOf(
            intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(1, 2), intArrayOf(3, 4)
        )
        assertEquals(3, solution.countCompleteComponents(6, edges))
    }

    @Test
    fun testExample2() {
        val edges = arrayOf(
            intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(1, 2),
            intArrayOf(3, 4), intArrayOf(3, 5)
        )
        assertEquals(1, solution.countCompleteComponents(6, edges))
    }

    @Test
    fun testNoEdges() {
        assertEquals(4, solution.countCompleteComponents(4, arrayOf()))
    }

    @Test
    fun testSingleNode() {
        assertEquals(1, solution.countCompleteComponents(1, arrayOf()))
    }

    @Test
    fun testCompleteGraph() {
        val edges = arrayOf(
            intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(1, 2)
        )
        assertEquals(1, solution.countCompleteComponents(3, edges))
    }
}
