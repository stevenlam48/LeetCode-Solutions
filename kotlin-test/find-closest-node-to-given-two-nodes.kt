package findclosestnodetogiventwonodes

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class FindClosestNodeToGivenTwoNodesTest {
    @Test
    fun sharedCycleNode() {
        assertEquals(2, Solution().closestMeetingNode(intArrayOf(2, 2, 3, -1), 0, 1))
    }

    @Test
    fun startingNodesMeetAtSecondStart() {
        assertEquals(2, Solution().closestMeetingNode(intArrayOf(1, 2, -1), 0, 2))
    }

    @Test
    fun sameStartingNode() {
        assertEquals(1, Solution().closestMeetingNode(intArrayOf(1, 2, -1), 1, 1))
    }

    @Test
    fun disconnectedCycles() {
        assertEquals(-1, Solution().closestMeetingNode(intArrayOf(1, 0, 3, 2), 0, 2))
    }
}
