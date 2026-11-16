package maximumrequestswithoutviolatingthelimit

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumRequestsWithoutViolatingTheLimitTest {
    private val solution = Solution()

    @Test
    fun rejectsRequestWithinFullWindow() {
        val requests = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 2),
            intArrayOf(0, 2),
            intArrayOf(0, 3)
        )

        assertEquals(3, solution.maxRequests(requests, 2, 2))
    }

    @Test
    fun sortsTimesBeforeApplyingSlidingWindow() {
        val requests = arrayOf(
            intArrayOf(0, 9),
            intArrayOf(0, 1),
            intArrayOf(0, 5)
        )

        assertEquals(3, solution.maxRequests(requests, 2, 4))
    }

    @Test
    fun handlesUsersIndependently() {
        val requests = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 1),
            intArrayOf(0, 2),
            intArrayOf(1, 2),
            intArrayOf(0, 3),
            intArrayOf(1, 3)
        )

        assertEquals(4, solution.maxRequests(requests, 2, 2))
    }

    @Test
    fun allowsRequestsAfterWindowMovesForward() {
        val requests = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(0, 2),
            intArrayOf(0, 10)
        )

        assertEquals(3, solution.maxRequests(requests, 2, 2))
    }
}
