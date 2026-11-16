package subtreeinversionsumii

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SubtreeInversionSumIiTest {
    @Test
    fun singleNode() {
        assertEquals(5, Solution().subtreeInversionSum(emptyArray(), intArrayOf(5), 1))
        assertEquals(5, Solution().subtreeInversionSum(emptyArray(), intArrayOf(-5), 1))
    }

    @Test
    fun invertNegativeChild() {
        val edges = arrayOf(intArrayOf(0, 1))
        assertEquals(11, Solution().subtreeInversionSum(edges, intArrayOf(1, -10), 1))
        assertEquals(11, Solution().subtreeInversionSum(edges, intArrayOf(1, -10), 2))
    }

    @Test
    fun positiveTreeCanRemainUnchanged() {
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2))
        assertEquals(6, Solution().subtreeInversionSum(edges, intArrayOf(1, 2, 3), 2))
    }

    @Test
    fun branchingTree() {
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(0, 2))
        assertEquals(12, Solution().subtreeInversionSum(edges, intArrayOf(2, -5, -5), 2))
    }
}
