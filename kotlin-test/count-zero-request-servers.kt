package countzerorequestservers

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class CountZeroRequestServersTest {
    @Test
    fun singleLog() {
        assertArrayEquals(
            intArrayOf(3, 2, 2),
            Solution().countServers(
                3,
                arrayOf(intArrayOf(1, 3)),
                2,
                intArrayOf(1, 3, 5)
            )
        )
    }

    @Test
    fun twoServers() {
        assertArrayEquals(
            intArrayOf(1, 0, 1),
            Solution().countServers(
                2,
                arrayOf(intArrayOf(1, 1), intArrayOf(2, 2)),
                1,
                intArrayOf(1, 2, 3)
            )
        )
    }

    @Test
    fun wideWindow() {
        assertArrayEquals(
            intArrayOf(3, 3, 3, 4),
            Solution().countServers(
                4,
                arrayOf(intArrayOf(1, 5)),
                10,
                intArrayOf(5, 14, 15, 16)
            )
        )
    }

    @Test
    fun emptyLogs() {
        assertArrayEquals(
            intArrayOf(1, 1),
            Solution().countServers(1, emptyArray(), 1, intArrayOf(1, 2))
        )
    }

    @Test
    fun severalLogsSameServer() {
        assertArrayEquals(
            intArrayOf(1, 3),
            Solution().countServers(
                3,
                arrayOf(intArrayOf(1, 2), intArrayOf(1, 4), intArrayOf(2, 3)),
                1,
                intArrayOf(4, 6)
            )
        )
    }
}
