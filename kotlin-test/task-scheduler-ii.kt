package taskschedulerii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TaskSchedulerIITest {
    @Test
    fun standardExamples() {
        assertEquals(9L, Solution().taskSchedulerII(intArrayOf(1, 2, 1, 2, 3, 1), 3))
        assertEquals(6L, Solution().taskSchedulerII(intArrayOf(5, 8, 8, 5), 2))
    }

    @Test
    fun emptyTaskList() {
        assertEquals(0L, Solution().taskSchedulerII(intArrayOf(), 3))
    }

    @Test
    fun noSpace() {
        assertEquals(4L, Solution().taskSchedulerII(intArrayOf(1, 1, 1, 1), 0))
    }
}
