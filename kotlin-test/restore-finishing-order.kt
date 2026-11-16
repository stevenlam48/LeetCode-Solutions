package restorefinishingorder

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class RestoreFinishingOrderTest {
    @Test
    fun example() {
        assertArrayEquals(
            intArrayOf(3, 1, 4),
            Solution().recoverOrder(intArrayOf(3, 1, 2, 5, 4), intArrayOf(1, 3, 4))
        )
    }

    @Test
    fun singleFriend() {
        assertArrayEquals(
            intArrayOf(2),
            Solution().recoverOrder(intArrayOf(1, 2), intArrayOf(2))
        )
    }

    @Test
    fun noFriends() {
        assertArrayEquals(
            intArrayOf(),
            Solution().recoverOrder(intArrayOf(1, 2, 3), intArrayOf(4))
        )
    }

    @Test
    fun allFriends() {
        assertArrayEquals(
            intArrayOf(5, 4, 3, 2, 1),
            Solution().recoverOrder(intArrayOf(5, 4, 3, 2, 1), intArrayOf(1, 2, 3, 4, 5))
        )
    }

    @Test
    fun keepsDuplicates() {
        assertArrayEquals(
            intArrayOf(1, 1),
            Solution().recoverOrder(intArrayOf(1, 1, 2), intArrayOf(1))
        )
    }
}
