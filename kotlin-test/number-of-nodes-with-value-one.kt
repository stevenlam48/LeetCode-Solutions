package numberofnodeswithvalueone

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfNodesWithValueOneTest {
    @Test
    fun togglesEntireSubtree() {
        assertEquals(2, Solution().numberOfNodes(2, intArrayOf(1)))
    }

    @Test
    fun combinesTogglesAtDifferentDepths() {
        assertEquals(1, Solution().numberOfNodes(7, intArrayOf(1, 2, 3)))
        assertEquals(4, Solution().numberOfNodes(7, intArrayOf(1, 2)))
    }

    @Test
    fun repeatedTogglesCancel() {
        assertEquals(0, Solution().numberOfNodes(7, intArrayOf(1, 1)))
        assertEquals(1, Solution().numberOfNodes(3, intArrayOf(2, 2, 2)))
    }

    @Test
    fun noQueriesLeavesAllNodesAtZero() {
        assertEquals(0, Solution().numberOfNodes(1, intArrayOf()))
        assertEquals(0, Solution().numberOfNodes(7, intArrayOf()))
    }
}
