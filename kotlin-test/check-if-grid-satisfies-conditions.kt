package checkifgridsatisfiesconditions

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CheckIfGridSatisfiesConditionsTest {
    private val solution = Solution()

    @Test
    fun validGrid() {
        assertTrue(solution.satisfiesConditions(arrayOf(
            intArrayOf(1, 0, 2),
            intArrayOf(1, 0, 2)
        )))
    }

    @Test
    fun differentValuesWithinColumn() {
        assertFalse(solution.satisfiesConditions(arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(0, 0, 0)
        )))
    }

    @Test
    fun equalAdjacentColumns() {
        assertFalse(solution.satisfiesConditions(arrayOf(
            intArrayOf(1, 1),
            intArrayOf(1, 1)
        )))
    }

    @Test
    fun singleColumn() {
        assertTrue(solution.satisfiesConditions(arrayOf(intArrayOf(0), intArrayOf(0))))
    }
}
