package numberofstudentreplacements

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfStudentReplacementsTest {
    private val solution = Solution()

    @Test
    fun example() {
        assertEquals(1, solution.totalReplacements(intArrayOf(4, 1, 2)))
    }

    @Test
    fun alreadyIncreasing() {
        assertEquals(0, solution.totalReplacements(intArrayOf(1, 2, 3)))
    }

    @Test
    fun empty() {
        assertEquals(-1, solution.totalReplacements(intArrayOf()))
    }

    @Test
    fun duplicatesAndNegatives() {
        assertEquals(2, solution.totalReplacements(intArrayOf(-1, -2, -2, -3)))
    }
}
