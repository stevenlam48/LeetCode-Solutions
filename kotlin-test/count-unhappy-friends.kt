package countunhappyfriends

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountUnhappyFriendsTest {
    @Test
    fun `example with two unhappy friends`() {
        val preferences = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(3, 2, 0),
            intArrayOf(3, 1, 0),
            intArrayOf(1, 2, 0)
        )
        val pairs = arrayOf(intArrayOf(0, 1), intArrayOf(2, 3))

        assertEquals(2, Solution().unhappyFriends(4, preferences, pairs))
    }

    @Test
    fun `single pair has no unhappy friends`() {
        val preferences = arrayOf(intArrayOf(1, 0), intArrayOf(0, 1))
        val pairs = arrayOf(intArrayOf(0, 1))

        assertEquals(0, Solution().unhappyFriends(2, preferences, pairs))
    }

    @Test
    fun `crossed pairings have no unhappy friends`() {
        val preferences = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(3, 2, 0),
            intArrayOf(3, 1, 0),
            intArrayOf(1, 2, 0)
        )
        val pairs = arrayOf(intArrayOf(0, 2), intArrayOf(1, 3))

        assertEquals(0, Solution().unhappyFriends(4, preferences, pairs))
    }
}
