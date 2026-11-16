package maximizemeetingearningswithidlegaps

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximizeMeetingEarningsWithIdleGapsTest {
    @Test
    fun unsortedOverlappingMeetings() {
        val meetings = arrayOf(
            intArrayOf(4, 7, 7),
            intArrayOf(0, 3, 5),
            intArrayOf(2, 5, 6)
        )
        assertEquals(13L, Solution().maxEarnings(meetings))
    }

    @Test
    fun disjointMeetingsIncludeIdleGaps() {
        val meetings = arrayOf(
            intArrayOf(1, 2, 5),
            intArrayOf(4, 6, 7),
            intArrayOf(8, 9, 10)
        )
        assertEquals(26L, Solution().maxEarnings(meetings))
    }

    @Test
    fun skipsOverlappingLowEarningsMeeting() {
        val meetings = arrayOf(
            intArrayOf(1, 4, 1),
            intArrayOf(2, 3, 20),
            intArrayOf(5, 6, 5)
        )
        assertEquals(27L, Solution().maxEarnings(meetings))
    }

    @Test
    fun singleLongMeetingCanBeBest() {
        val meetings = arrayOf(
            intArrayOf(1, 10, 100),
            intArrayOf(2, 3, 4),
            intArrayOf(4, 5, 4),
            intArrayOf(6, 7, 4)
        )
        assertEquals(100L, Solution().maxEarnings(meetings))
    }

    @Test
    fun noMeetings() {
        assertEquals(0L, Solution().maxEarnings(emptyArray()))
    }
}
