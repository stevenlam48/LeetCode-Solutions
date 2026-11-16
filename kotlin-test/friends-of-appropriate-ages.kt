package friendsofappropriateages

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FriendsOfAppropriateAgesTest {
    @Test
    fun example1() {
        assertEquals(2, Solution().numFriendRequests(intArrayOf(16, 16)))
    }

    @Test
    fun example2() {
        assertEquals(2, Solution().numFriendRequests(intArrayOf(16, 17, 18)))
    }

    @Test
    fun example3() {
        assertEquals(3, Solution().numFriendRequests(intArrayOf(20, 30, 100, 110, 120)))
    }

    @Test
    fun singlePerson() {
        assertEquals(0, Solution().numFriendRequests(intArrayOf(25)))
    }

    @Test
    fun boundaryHalfPlusSeven() {
        assertEquals(0, Solution().numFriendRequests(intArrayOf(14, 22)))
    }
}
