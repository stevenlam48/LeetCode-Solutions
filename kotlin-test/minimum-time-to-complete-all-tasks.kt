package minimumtimetocompletealltasks

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumTimeToCompleteAllTasksTest {
    @Test
    fun overlappingTasks() {
        val tasks = arrayOf(intArrayOf(2, 3, 1), intArrayOf(4, 5, 1), intArrayOf(1, 5, 2))
        assertEquals(2, Solution().findMinimumTime(tasks))
    }

    @Test
    fun chainedTasks() {
        val tasks = arrayOf(intArrayOf(1, 3, 2), intArrayOf(2, 5, 3), intArrayOf(5, 6, 2))
        assertEquals(4, Solution().findMinimumTime(tasks))
    }

    @Test
    fun singleTask() {
        assertEquals(3, Solution().findMinimumTime(arrayOf(intArrayOf(1, 4, 3))))
    }

    @Test
    fun unsortedDisjointTasks() {
        val tasks = arrayOf(intArrayOf(8, 9, 2), intArrayOf(2, 4, 2))
        assertEquals(4, Solution().findMinimumTime(tasks))
    }
}
