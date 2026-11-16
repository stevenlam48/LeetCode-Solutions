package pathwithmaximumprobability

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PathWithMaximumProbabilityTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(0, 2))
        val succProb = doubleArrayOf(0.5, 0.5, 0.2)
        assertEquals(0.25, solution.maxProbability(3, edges, succProb, 0, 2), 1e-9)
    }

    @Test
    fun testExample2() {
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(0, 2))
        val succProb = doubleArrayOf(0.5, 0.5, 0.3)
        assertEquals(0.3, solution.maxProbability(3, edges, succProb, 0, 2), 1e-9)
    }

    @Test
    fun testDisconnected() {
        val edges = arrayOf(intArrayOf(0, 1))
        val succProb = doubleArrayOf(0.5)
        assertEquals(0.0, solution.maxProbability(3, edges, succProb, 0, 2), 1e-9)
    }

    @Test
    fun testDirectEdge() {
        val edges = arrayOf(intArrayOf(0, 1))
        val succProb = doubleArrayOf(0.7)
        assertEquals(0.7, solution.maxProbability(2, edges, succProb, 0, 1), 1e-9)
    }
}
