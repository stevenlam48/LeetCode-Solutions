package bestmeetingpoint

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BestMeetingPointTest {
    private val solution = Solution()

    @Test
    fun example() {
        assertEquals(
            6,
            solution.minTotalDistance(
                arrayOf(
                    intArrayOf(1, 0, 0, 0, 1),
                    intArrayOf(0, 0, 0, 0, 0),
                    intArrayOf(0, 0, 1, 0, 0)
                )
            )
        )
    }

    @Test
    fun singleFriend() {
        assertEquals(0, solution.minTotalDistance(arrayOf(intArrayOf(0, 0, 1))))
    }

    @Test
    fun oddNumberOfFriendsInLine() {
        assertEquals(
            4,
            solution.minTotalDistance(
                arrayOf(intArrayOf(1), intArrayOf(0), intArrayOf(1), intArrayOf(0), intArrayOf(1))
            )
        )
    }

    @Test
    fun evenNumberOfFriends() {
        assertEquals(
            4,
            solution.minTotalDistance(arrayOf(intArrayOf(1, 1), intArrayOf(1, 1)))
        )
    }
}
