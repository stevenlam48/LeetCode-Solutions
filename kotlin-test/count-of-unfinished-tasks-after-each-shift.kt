package countofunfinishedtasksaftereachshift

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CountOfUnfinishedTasksAfterEachShiftTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertArrayEquals(intArrayOf(2, 1, 0), solution.countTasks(intArrayOf(1, 2, 3), intArrayOf(1, 2, 3)))
    }

    @Test
    fun testSingleTask() {
        assertArrayEquals(intArrayOf(1, 0), solution.countTasks(intArrayOf(5), intArrayOf(2, 4)))
    }

    @Test
    fun testExactCompletion() {
        assertArrayEquals(intArrayOf(0), solution.countTasks(intArrayOf(1), intArrayOf(1)))
    }

    @Test
    fun testEmptyShifts() {
        assertArrayEquals(intArrayOf(), solution.countTasks(intArrayOf(1, 2), intArrayOf()))
    }

    @Test
    fun testLargeShiftResets() {
        assertArrayEquals(intArrayOf(2, 0), solution.countTasks(intArrayOf(2, 3), intArrayOf(1, 10)))
    }
}
