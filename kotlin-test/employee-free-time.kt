package employeefreetime

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class EmployeeFreeTimeTest {
    private val solution = Solution()

    @Test
    fun `finds common gaps across employee schedules`() {
        val schedule = listOf(
            listOf(Interval(1, 3), Interval(6, 7)),
            listOf(Interval(2, 4)),
            listOf(Interval(2, 5), Interval(9, 12))
        )

        assertEquals(listOf(Interval(5, 6), Interval(7, 9)), solution.employeeFreeTime(schedule))
    }

    @Test
    fun `overlapping boundaries do not create free time`() {
        val schedule = listOf(
            listOf(Interval(1, 2), Interval(5, 6)),
            listOf(Interval(1, 3)),
            listOf(Interval(4, 10))
        )

        assertEquals(listOf(Interval(3, 4)), solution.employeeFreeTime(schedule))
    }

    @Test
    fun `single employee contributes all internal gaps`() {
        val schedule = listOf(listOf(Interval(1, 2), Interval(4, 6), Interval(8, 9)))

        assertEquals(listOf(Interval(2, 4), Interval(6, 8)), solution.employeeFreeTime(schedule))
    }

    @Test
    fun `touching intervals produce no zero length gaps`() {
        val schedule = listOf(
            listOf(Interval(1, 3), Interval(3, 5)),
            listOf(Interval(2, 4), Interval(5, 8))
        )

        assertEquals(emptyList<Interval>(), solution.employeeFreeTime(schedule))
    }
}
