package minimumnumberofgroupstocreateavalidassignment

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumNumberOfGroupsToCreateAValidAssignmentTest {
    private val solution = Solution()

    @Test
    fun validGroupsWithDifferentSizes() {
        assertEquals(2, solution.minGroupsForValidAssignment(intArrayOf(3, 2, 3, 2, 3)))
    }

    @Test
    fun threeOccurrencesOfEach() {
        assertEquals(2, solution.minGroupsForValidAssignment(intArrayOf(10, 10, 10, 3, 3, 3)))
    }

    @Test
    fun mixedFrequencies() {
        assertEquals(
            5,
            solution.minGroupsForValidAssignment(intArrayOf(1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3))
        )
    }

    @Test
    fun singleElement() {
        assertEquals(1, solution.minGroupsForValidAssignment(intArrayOf(1)))
    }
}
