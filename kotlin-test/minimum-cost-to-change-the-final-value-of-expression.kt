package minimumcosttochangethefinalvalueofexpression

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumCostToChangeTheFinalValueOfExpressionTest {
    private val solution = Solution()

    @Test
    fun singleOperands() {
        assertEquals(1, solution.minOperationsToFlip("0"))
        assertEquals(1, solution.minOperationsToFlip("1"))
    }

    @Test
    fun leetCodeExample() {
        assertEquals(1, solution.minOperationsToFlip("1&(0|1)"))
    }

    @Test
    fun repeatedAndRequiresChangingEveryZero() {
        assertEquals(2, solution.minOperationsToFlip("0&0&0"))
    }

    @Test
    fun nestedParentheses() {
        assertEquals(1, solution.minOperationsToFlip("(0|1)&1"))
    }
}
