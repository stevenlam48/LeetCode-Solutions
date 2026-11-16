package theemployeethatworkedonthelongesttask

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TheEmployeeThatWorkedOnTheLongestTaskTest {
    @Test
    fun standardExamples() {
        assertEquals(
            0,
            Solution().hardestWorker(
                10,
                arrayOf(intArrayOf(0, 3), intArrayOf(2, 5), intArrayOf(0, 9), intArrayOf(1, 12))
            )
        )
        assertEquals(
            1,
            Solution().hardestWorker(70, arrayOf(intArrayOf(0, 3), intArrayOf(1, 7), intArrayOf(2, 10)))
        )
    }

    @Test
    fun tiesUseSmallestEmployeeId() {
        val logs = arrayOf(intArrayOf(2, 5), intArrayOf(0, 10), intArrayOf(1, 15))
        assertEquals(0, Solution().hardestWorker(3, logs))
    }

    @Test
    fun emptyLogs() {
        assertEquals(-1, Solution().hardestWorker(1, emptyArray()))
    }
}
