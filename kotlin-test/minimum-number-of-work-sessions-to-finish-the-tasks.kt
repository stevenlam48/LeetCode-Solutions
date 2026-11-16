package minimumnumberofworksessionstofinishthetasks

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MinimumNumberOfWorkSessionsToFinishTheTasksTest {

    @Test
    fun testExample1() {
        assertEquals(2, Solution().minSessions(intArrayOf(1, 2, 3), 3))
    }

    @Test
    fun testExample2() {
        assertEquals(2, Solution().minSessions(intArrayOf(3, 1, 3, 1, 1), 8))
    }

    @Test
    fun testExample3() {
        assertEquals(1, Solution().minSessions(intArrayOf(1, 2, 3, 4, 5), 15))
    }

    @Test
    fun testSingleTask() {
        assertEquals(1, Solution().minSessions(intArrayOf(5), 5))
    }

    @Test
    fun testEachTaskNeedsOwnSession() {
        assertEquals(4, Solution().minSessions(intArrayOf(4, 4, 4, 4), 5))
    }

    @Test
    fun testAllTasksFitOneSession() {
        assertEquals(1, Solution().minSessions(intArrayOf(1, 2, 3), 6))
    }

    @Test
    fun testExactFill() {
        assertEquals(2, Solution().minSessions(intArrayOf(2, 2, 2, 2), 4))
    }
}
