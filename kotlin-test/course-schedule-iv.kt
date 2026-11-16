package coursescheduleiv

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class CourseScheduleIvTest {
    @Test
    fun `checks direct prerequisites`() {
        val result = Solution().checkIfPrerequisite(
            2, arrayOf(intArrayOf(0, 1)), arrayOf(intArrayOf(0, 1), intArrayOf(1, 0))
        )
        assertArrayEquals(booleanArrayOf(true, false), result)
    }

    @Test
    fun `returns false when there are no prerequisites`() {
        val result = Solution().checkIfPrerequisite(
            2, emptyArray(), arrayOf(intArrayOf(0, 1), intArrayOf(1, 0))
        )
        assertArrayEquals(booleanArrayOf(false, false), result)
    }

    @Test
    fun `checks transitive reachability in both directions`() {
        val result = Solution().checkIfPrerequisite(
            3,
            arrayOf(intArrayOf(0, 1), intArrayOf(1, 2)),
            arrayOf(intArrayOf(0, 2), intArrayOf(0, 1), intArrayOf(2, 0))
        )
        assertArrayEquals(booleanArrayOf(true, true, false), result)
    }

    @Test
    fun `handles an empty query list`() {
        assertArrayEquals(booleanArrayOf(), Solution().checkIfPrerequisite(1, emptyArray(), emptyArray()))
    }
}
