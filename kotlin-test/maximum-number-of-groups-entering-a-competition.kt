package maximumnumberofgroupsenteringacompetition

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MaximumNumberOfGroupsEnteringACompetitionTest {
    private val solution = Solution()

    @Test
    fun standardExample() {
        assertEquals(3, solution.maximumGroups(intArrayOf(10, 6, 12, 7, 3, 5)))
    }

    @Test
    fun twoGrades() {
        assertEquals(1, solution.maximumGroups(intArrayOf(8, 8)))
    }

    @Test
    fun emptyAndSingleInput() {
        assertEquals(0, solution.maximumGroups(intArrayOf()))
        assertEquals(1, solution.maximumGroups(intArrayOf(1)))
    }

    @Test
    fun tenGradesAllowFourGroups() {
        assertEquals(4, solution.maximumGroups(IntArray(10) { it }))
    }

    @Test
    fun nineGradesAllowThreeGroups() {
        assertEquals(3, solution.maximumGroups(IntArray(9) { it }))
    }
}
