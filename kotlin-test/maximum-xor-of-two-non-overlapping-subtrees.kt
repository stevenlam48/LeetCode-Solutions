package maximumxoroftwononoverlappingsubtrees

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumXorOfTwoNonOverlappingSubtreesTest {
    private val solution = Solution()

    @Test
    fun twoLeafSubtrees() {
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(0, 2))
        assertEquals(6L, solution.maxXor(3, edges, intArrayOf(1, 2, 4)))
    }

    @Test
    fun parentAndChildOnlyOverlap() {
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(1, 3))
        assertEquals(14L, solution.maxXor(4, edges, intArrayOf(1, 2, 4, 8)))
    }

    @Test
    fun singleNodeHasNoPair() {
        assertEquals(0L, solution.maxXor(1, arrayOf(), intArrayOf(5)))
    }

    @Test
    fun twoNodesOnlyOverlappingSubtrees() {
        val edges = arrayOf(intArrayOf(0, 1))
        assertEquals(0L, solution.maxXor(2, edges, intArrayOf(1, 2)))
    }
}
