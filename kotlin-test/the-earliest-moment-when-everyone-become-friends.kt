package theearliestmomentwheneveryonebecomefriends

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TheEarliestMomentWhenEveryoneBecomeFriendsTest {
    @Test
    fun connectedAfterAllLogs() {
        val logs = arrayOf(
            intArrayOf(20190101, 0, 1),
            intArrayOf(20190104, 3, 4),
            intArrayOf(20190107, 2, 3),
            intArrayOf(20190211, 1, 5),
            intArrayOf(20190224, 2, 4),
            intArrayOf(20190301, 0, 3),
            intArrayOf(20190312, 1, 2),
            intArrayOf(20190322, 4, 5)
        )
        assertEquals(20190301, Solution().earliestAcq(logs, 6))
    }

    @Test
    fun connectedBeforeLastLog() {
        val logs = arrayOf(intArrayOf(0, 2, 0), intArrayOf(1, 0, 1), intArrayOf(3, 0, 3))
        assertEquals(3, Solution().earliestAcq(logs, 4))
    }

    @Test
    fun disconnectedGroup() {
        assertEquals(-1, Solution().earliestAcq(arrayOf(intArrayOf(1, 0, 1)), 3))
    }

    @Test
    fun duplicateFriendshipDoesNotReduceGroups() {
        val logs = arrayOf(intArrayOf(1, 0, 1), intArrayOf(2, 0, 1), intArrayOf(3, 1, 2))
        assertEquals(3, Solution().earliestAcq(logs, 3))
    }
}
