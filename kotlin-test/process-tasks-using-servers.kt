package processtasksusingservers

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class ProcessTasksUsingServersTest {
    private val solution = Solution()

    @Test
    fun validCase1() {
        val actual = solution.assignTasks(intArrayOf(3, 3, 2), intArrayOf(1, 2, 3, 2, 1, 2))
        assertArrayEquals(intArrayOf(2, 2, 0, 2, 1, 2), actual)
    }

    @Test
    fun validCase2() {
        val actual = solution.assignTasks(
            intArrayOf(5, 1, 4, 3, 2),
            intArrayOf(2, 1, 2, 4, 5, 2, 1)
        )
        assertArrayEquals(intArrayOf(1, 4, 1, 4, 1, 3, 2), actual)
    }

    @Test
    fun validCase3_singleServer() {
        val actual = solution.assignTasks(intArrayOf(1), intArrayOf(3, 2))
        assertArrayEquals(intArrayOf(0, 0), actual)
    }

    @Test
    fun validCase4_equalWeightUsesIndex() {
        val actual = solution.assignTasks(intArrayOf(2, 2), intArrayOf(1, 1, 1))
        assertArrayEquals(intArrayOf(0, 0, 0), actual)
    }

    @Test
    fun validCase5_earliestCompletionServerWinsWait() {
        val actual = solution.assignTasks(intArrayOf(4, 1), intArrayOf(3, 1, 2, 1))
        assertArrayEquals(intArrayOf(1, 0, 0, 1), actual)
    }

    @Test
    fun validCase6_serverReleasedBeforeNextTask() {
        val actual = solution.assignTasks(intArrayOf(5, 1), intArrayOf(2, 2, 1))
        assertArrayEquals(intArrayOf(1, 0, 1), actual)
    }
}
