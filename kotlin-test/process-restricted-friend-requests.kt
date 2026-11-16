package processrestrictedfriendrequests

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class ProcessRestrictedFriendRequestsTest {
    private val solution = Solution()

    @Test
    fun validCase1() {
        val actual = solution.friendRequests(
            3,
            arrayOf(intArrayOf(0, 1)),
            arrayOf(intArrayOf(0, 2), intArrayOf(2, 1))
        )
        assertArrayEquals(booleanArrayOf(true, false), actual)
    }

    @Test
    fun validCase2() {
        val actual = solution.friendRequests(
            3,
            arrayOf(intArrayOf(0, 1)),
            arrayOf(intArrayOf(1, 2), intArrayOf(0, 2))
        )
        assertArrayEquals(booleanArrayOf(true, false), actual)
    }

    @Test
    fun validCase3_multipleRestrictions() {
        val actual = solution.friendRequests(
            5,
            arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(2, 3)),
            arrayOf(
                intArrayOf(0, 4), intArrayOf(1, 2),
                intArrayOf(3, 1), intArrayOf(3, 4)
            )
        )
        assertArrayEquals(booleanArrayOf(true, false, true, false), actual)
    }

    @Test
    fun validCase4_noRestrictions() {
        val actual = solution.friendRequests(
            4,
            emptyArray(),
            arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(0, 3))
        )
        assertArrayEquals(booleanArrayOf(true, true, true), actual)
    }

    @Test
    fun validCase5_directRestriction() {
        val actual = solution.friendRequests(
            2,
            arrayOf(intArrayOf(0, 1)),
            arrayOf(intArrayOf(0, 1))
        )
        assertArrayEquals(booleanArrayOf(false), actual)
    }

    @Test
    fun validCase6_transitiveRestriction() {
        val actual = solution.friendRequests(
            4,
            arrayOf(intArrayOf(0, 1)),
            arrayOf(intArrayOf(0, 2), intArrayOf(1, 2), intArrayOf(1, 3))
        )
        assertArrayEquals(booleanArrayOf(true, false, true), actual)
    }
}
