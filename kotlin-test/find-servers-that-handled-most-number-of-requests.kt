package findserversthathandledmostnumberofrequests

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindServersThatHandledMostNumberOfRequestsTest {
    @Test
    fun testExample1() {
        assertEquals(
            listOf(1),
            Solution().busiestServers(3, intArrayOf(1, 2, 3, 4, 5), intArrayOf(5, 2, 3, 3, 3))
        )
    }

    @Test
    fun testExample2() {
        assertEquals(
            listOf(0),
            Solution().busiestServers(3, intArrayOf(1, 2, 3, 4), intArrayOf(1, 2, 1, 2))
        )
    }

    @Test
    fun testExample3() {
        assertEquals(
            listOf(0, 1, 2),
            Solution().busiestServers(3, intArrayOf(1, 2, 3), intArrayOf(10, 12, 11))
        )
    }

    @Test
    fun testSingleServer() {
        assertEquals(
            listOf(0),
            Solution().busiestServers(1, intArrayOf(1, 2, 3), intArrayOf(1, 1, 1))
        )
    }
}
