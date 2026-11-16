package numberofstudentsdoinghomeworkatagiventime

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfStudentsDoingHomeworkAtAGivenTimeTest {
    private val solution = Solution()

    @Test
    fun example() {
        assertEquals(1, solution.busyStudent(intArrayOf(1, 2, 3), intArrayOf(3, 2, 7), 4))
    }

    @Test
    fun boundariesAreInclusive() {
        assertEquals(2, solution.busyStudent(intArrayOf(1, 2, 3), intArrayOf(3, 2, 7), 2))
        assertEquals(2, solution.busyStudent(intArrayOf(1, 2, 3), intArrayOf(3, 2, 7), 3))
    }

    @Test
    fun noStudents() {
        assertEquals(0, solution.busyStudent(intArrayOf(), intArrayOf(), 1))
    }

    @Test
    fun outsideIntervals() {
        assertEquals(0, solution.busyStudent(intArrayOf(5, 6), intArrayOf(7, 8), 4))
    }
}
