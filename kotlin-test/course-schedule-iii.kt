package coursescheduleiii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CourseScheduleIiiTest {
    @Test
    fun `replaces a long course to take three courses`() {
        val courses = arrayOf(
            intArrayOf(100, 200), intArrayOf(200, 1300),
            intArrayOf(1000, 1250), intArrayOf(2000, 3200)
        )
        assertEquals(3, Solution().scheduleCourse(courses))
    }

    @Test
    fun `takes one course that exactly meets its deadline`() {
        assertEquals(1, Solution().scheduleCourse(arrayOf(intArrayOf(1, 2))))
    }

    @Test
    fun `drops courses that cannot meet their deadlines`() {
        val courses = arrayOf(intArrayOf(3, 2), intArrayOf(4, 3))
        assertEquals(0, Solution().scheduleCourse(courses))
    }

    @Test
    fun `selects the shortest compatible courses`() {
        val courses = arrayOf(intArrayOf(5, 5), intArrayOf(4, 6), intArrayOf(2, 6))
        assertEquals(2, Solution().scheduleCourse(courses))
    }
}
