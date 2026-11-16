package findingtheusersactiveminutes

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class FindingTheUsersActiveMinutesTest {
    @Test
    fun exampleOne() {
        val logs = arrayOf(
            intArrayOf(0, 5), intArrayOf(1, 2), intArrayOf(0, 2),
            intArrayOf(0, 5), intArrayOf(1, 3)
        )
        assertArrayEquals(intArrayOf(0, 2, 0, 0, 0), Solution().findingUsersActiveMinutes(logs, 5))
    }

    @Test
    fun exampleTwo() {
        val logs = arrayOf(intArrayOf(1, 1), intArrayOf(2, 2), intArrayOf(2, 3))
        assertArrayEquals(intArrayOf(1, 1, 0, 0), Solution().findingUsersActiveMinutes(logs, 4))
    }

    @Test
    fun duplicateMinutesCountOnce() {
        val logs = arrayOf(intArrayOf(7, 1), intArrayOf(7, 1), intArrayOf(7, 1))
        assertArrayEquals(intArrayOf(1, 0), Solution().findingUsersActiveMinutes(logs, 2))
    }

    @Test
    fun emptyLogs() {
        assertArrayEquals(intArrayOf(0, 0, 0), Solution().findingUsersActiveMinutes(emptyArray(), 3))
    }
}
