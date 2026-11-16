package maximumemployeestobeinvitedtoameeting

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumEmployeesToBeInvitedToAMeetingTest {
    @Test
    fun example1() {
        assertEquals(3, Solution().maximumInvitations(intArrayOf(2, 2, 1, 2)))
    }

    @Test
    fun example2() {
        assertEquals(3, Solution().maximumInvitations(intArrayOf(1, 2, 0)))
    }

    @Test
    fun example3() {
        assertEquals(4, Solution().maximumInvitations(intArrayOf(3, 0, 1, 4, 1)))
    }

    @Test
    fun twoMutualPairs() {
        assertEquals(4, Solution().maximumInvitations(intArrayOf(1, 0, 3, 2)))
    }

    @Test
    fun twoEmployees() {
        assertEquals(2, Solution().maximumInvitations(intArrayOf(1, 0)))
    }

    @Test
    fun longCycle() {
        assertEquals(5, Solution().maximumInvitations(intArrayOf(1, 2, 3, 4, 0)))
    }
}
