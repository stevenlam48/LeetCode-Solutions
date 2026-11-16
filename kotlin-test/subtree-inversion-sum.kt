package subtreeinversionsum

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SubtreeInversionSumTest {
    @Test
    fun singleNode() {
        assertEquals(5L, Solution().subtreeInversionSum(emptyArray(), intArrayOf(5), 1))
        assertEquals(5L, Solution().subtreeInversionSum(emptyArray(), intArrayOf(-5), 1))
    }

    @Test
    fun distancePreventsInversion() {
        val edges = arrayOf(intArrayOf(0, 1))
        assertEquals(3L, Solution().subtreeInversionSum(edges, intArrayOf(1, 2), 2))
    }

    @Test
    fun invertDeepNegativeNode() {
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2))
        assertEquals(13L, Solution().subtreeInversionSum(edges, intArrayOf(1, 2, -10), 2))
        assertEquals(13L, Solution().subtreeInversionSum(edges, intArrayOf(1, 2, -10), 1))
    }

    @Test
    fun branchingTree() {
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(0, 2))
        assertEquals(12L, Solution().subtreeInversionSum(edges, intArrayOf(2, -5, -5), 1))
    }
}
