package courseschedule

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CourseScheduleTest {
    @Test
    fun `a single prerequisite can be completed`() {
        assertTrue(Solution().canFinish(2, arrayOf(intArrayOf(1, 0))))
    }

    @Test
    fun `a cycle prevents completion`() {
        assertFalse(Solution().canFinish(2, arrayOf(intArrayOf(1, 0), intArrayOf(0, 1))))
    }

    @Test
    fun `disconnected courses and a longer chain can be completed`() {
        val prerequisites = arrayOf(intArrayOf(1, 0), intArrayOf(2, 1))
        assertTrue(Solution().canFinish(5, prerequisites))
    }

    @Test
    fun `no courses or prerequisites can be finished`() {
        assertTrue(Solution().canFinish(0, emptyArray()))
        assertTrue(Solution().canFinish(3, emptyArray()))
    }
}
