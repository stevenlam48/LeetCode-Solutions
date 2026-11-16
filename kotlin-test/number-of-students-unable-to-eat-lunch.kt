package numberofstudentsunabletoeatlunch

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfStudentsUnableToEatLunchTest {
    private val solution = Solution()

    @Test
    fun exampleOne() {
        assertEquals(0, solution.countStudents(intArrayOf(1, 1, 0, 0), intArrayOf(0, 1, 0, 1)))
    }

    @Test
    fun exampleTwo() {
        assertEquals(3, solution.countStudents(intArrayOf(1, 1, 1, 0, 0, 1), intArrayOf(1, 0, 0, 0, 1, 1)))
    }

    @Test
    fun empty() {
        assertEquals(0, solution.countStudents(intArrayOf(), intArrayOf()))
    }

    @Test
    fun firstSandwichHasNoTakers() {
        assertEquals(2, solution.countStudents(intArrayOf(0, 0), intArrayOf(1, 1)))
    }
}
