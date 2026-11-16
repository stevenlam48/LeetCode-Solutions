package countthenumberofsquarefreesubsets

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountTheNumberOfSquareFreeSubsetsTest {
    private val solution = Solution()

    @Test
    fun `leetcode example with duplicates and non square free values`() {
        assertEquals(3, solution.squareFreeSubsets(intArrayOf(3, 4, 4, 5)))
    }

    @Test
    fun `only ones count every nonempty subset`() {
        assertEquals(1, solution.squareFreeSubsets(intArrayOf(1)))
        assertEquals(3, solution.squareFreeSubsets(intArrayOf(1, 1)))
    }

    @Test
    fun `coprime values can all be combined`() {
        assertEquals(7, solution.squareFreeSubsets(intArrayOf(2, 3, 5)))
    }

    @Test
    fun `duplicate square free values cannot be selected together`() {
        assertEquals(2, solution.squareFreeSubsets(intArrayOf(2, 2)))
    }

    @Test
    fun `non square free values are excluded`() {
        assertEquals(0, solution.squareFreeSubsets(intArrayOf(4, 8, 12)))
    }
}
