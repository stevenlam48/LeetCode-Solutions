package divideanarrayintosubarrayswithminimumcosti

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DivideAnArrayIntoSubarraysWithMinimumCostITest {
    private val solution = Solution()

    @Test
    fun standardExample() {
        assertEquals(6, solution.minimumCost(intArrayOf(1, 2, 3, 12)))
    }

    @Test
    fun minimumLength() {
        assertEquals(12, solution.minimumCost(intArrayOf(5, 4, 3)))
    }

    @Test
    fun duplicateMinimumValues() {
        assertEquals(12, solution.minimumCost(intArrayOf(10, 3, 1, 1)))
    }

    @Test
    fun negativeValues() {
        assertEquals(-8, solution.minimumCost(intArrayOf(-1, -2, -3, -4)))
    }
}
