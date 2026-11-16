package longestspecialpathii

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LongestSpecialPathIiTest {
    @Test
    fun secondOccurrenceCanJoinThePath() {
        val edges = arrayOf(intArrayOf(0, 1, 2), intArrayOf(1, 2, 3))
        assertArrayEquals(intArrayOf(5, 3), Solution().longestSpecialPath(edges, intArrayOf(1, 2, 1)))
    }

    @Test
    fun longestCandidateWinsBeforeNodeCount() {
        val edges = arrayOf(intArrayOf(0, 1, 5), intArrayOf(1, 2, 5), intArrayOf(0, 3, 5))
        assertArrayEquals(intArrayOf(10, 3), Solution().longestSpecialPath(edges, intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun thirdOccurrenceIsExcluded() {
        val edges = arrayOf(intArrayOf(0, 1, 1), intArrayOf(1, 2, 1), intArrayOf(2, 3, 1))
        assertArrayEquals(intArrayOf(2, 3), Solution().longestSpecialPath(edges, intArrayOf(1, 1, 1, 2)))
    }
}
