package taskscheduler

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TaskSchedulerTest {
    @Test
    fun standardExample() {
        assertEquals(8, Solution().leastInterval(charArrayOf('A', 'A', 'A', 'B', 'B', 'B'), 2))
    }

    @Test
    fun noCooldown() {
        assertEquals(6, Solution().leastInterval(charArrayOf('A', 'A', 'A', 'B', 'B', 'B'), 0))
    }

    @Test
    fun manyDistinctTasks() {
        assertEquals(
            10,
            Solution().leastInterval(charArrayOf('A', 'A', 'A', 'A', 'B', 'B', 'C', 'D', 'E', 'F'), 2)
        )
    }

    @Test
    fun singleTask() {
        assertEquals(1, Solution().leastInterval(charArrayOf('A'), 2))
    }
}
