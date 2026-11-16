package divideanarrayintosubarrayswithminimumcostii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DivideAnArrayIntoSubarraysWithMinimumCostIiTest {
    private val solution = Solution()

    @Test
    fun firstStandardExample() {
        assertEquals(5L, solution.minimumCost(intArrayOf(1, 3, 2, 6, 4, 2), 3, 3))
    }

    @Test
    fun secondStandardExample() {
        assertEquals(15L, solution.minimumCost(intArrayOf(10, 1, 2, 2, 2, 1), 4, 3))
    }

    @Test
    fun thirdStandardExample() {
        assertEquals(36L, solution.minimumCost(intArrayOf(10, 8, 18, 9), 3, 1))
    }

    @Test
    fun duplicateValuesInWindow() {
        assertEquals(7L, solution.minimumCost(intArrayOf(4, 2, 2, 1), 3, 1))
    }
}
