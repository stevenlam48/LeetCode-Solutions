package coursescheduleii

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class CourseScheduleIiTest {
    @Test
    fun `finds the order for one prerequisite`() {
        assertArrayEquals(intArrayOf(0, 1), Solution().findOrder(2, arrayOf(intArrayOf(1, 0))))
    }

    @Test
    fun `finds a breadth first topological order`() {
        val prerequisites = arrayOf(
            intArrayOf(1, 0), intArrayOf(2, 0), intArrayOf(3, 1), intArrayOf(3, 2)
        )
        assertArrayEquals(intArrayOf(0, 1, 2, 3), Solution().findOrder(4, prerequisites))
    }

    @Test
    fun `returns an empty order for a cycle`() {
        val prerequisites = arrayOf(intArrayOf(1, 0), intArrayOf(0, 1))
        assertArrayEquals(intArrayOf(), Solution().findOrder(2, prerequisites))
    }

    @Test
    fun `returns every course when there are no prerequisites`() {
        assertArrayEquals(intArrayOf(0, 1, 2), Solution().findOrder(3, emptyArray()))
    }
}
