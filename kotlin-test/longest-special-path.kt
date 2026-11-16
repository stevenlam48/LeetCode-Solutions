package longestspecialpath

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LongestSpecialPathTest {
    @Test
    fun standardTreeExample() {
        val edges = arrayOf(
            intArrayOf(0, 1, 2),
            intArrayOf(1, 2, 3),
            intArrayOf(1, 3, 5),
            intArrayOf(1, 4, 4),
            intArrayOf(2, 5, 6)
        )
        assertArrayEquals(
            intArrayOf(9, 3),
            Solution().longestSpecialPath(edges, intArrayOf(2, 1, 2, 1, 3, 4))
        )
    }

    @Test
    fun duplicatedValuesCanLeaveOnlySingleNodePaths() {
        val edges = arrayOf(intArrayOf(1, 0, 8))
        assertArrayEquals(intArrayOf(0, 1), Solution().longestSpecialPath(edges, intArrayOf(2, 2)))
    }

    @Test
    fun longestCandidateWinsBeforeNodeCount() {
        val edges = arrayOf(intArrayOf(0, 1, 5), intArrayOf(1, 2, 5), intArrayOf(0, 3, 5))
        assertArrayEquals(intArrayOf(10, 3), Solution().longestSpecialPath(edges, intArrayOf(1, 2, 3, 4)))
    }
}
