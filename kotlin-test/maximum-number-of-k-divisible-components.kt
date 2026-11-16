package maximumnumberofkdivisiblecomponents

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MaximumNumberOfKDivisibleComponentsTest {
    private val solution = Solution()

    @Test
    fun standardExampleFiveNodes() {
        val edges = arrayOf(intArrayOf(0, 2), intArrayOf(1, 2), intArrayOf(1, 3), intArrayOf(2, 4))
        assertEquals(2, solution.maxKDivisibleComponents(5, edges, intArrayOf(1, 8, 1, 4, 4), 6))
    }

    @Test
    fun standardExampleSevenNodes() {
        val edges = arrayOf(
            intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(1, 3),
            intArrayOf(1, 4), intArrayOf(2, 5), intArrayOf(2, 6)
        )
        assertEquals(3, solution.maxKDivisibleComponents(7, edges, intArrayOf(3, 0, 6, 1, 5, 2, 1), 3))
    }

    @Test
    fun singleNode() {
        assertEquals(1, solution.maxKDivisibleComponents(1, emptyArray(), intArrayOf(5), 5))
    }

    @Test
    fun everyNodeIsDivisible() {
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2))
        assertEquals(3, solution.maxKDivisibleComponents(3, edges, intArrayOf(3, 3, 3), 3))
    }

    @Test
    fun onlyWholeTreeIsDivisible() {
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2))
        assertEquals(1, solution.maxKDivisibleComponents(3, edges, intArrayOf(1, 1, 1), 3))
    }
}
