package leastoperatorstoexpressnumber

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LeastOperatorsToExpressNumberTest {
    private val solution = Solution()

    @Test
    fun combinesPositiveAndNegativePowers() {
        assertEquals(5, solution.leastOpsExpressTarget(3, 19))
    }

    @Test
    fun handlesLeetCodeLargeTargetExample() {
        assertEquals(8, solution.leastOpsExpressTarget(5, 501))
    }

    @Test
    fun usesOnlyMultiplicationForExactPower() {
        assertEquals(3, solution.leastOpsExpressTarget(100, 100000000))
    }

    @Test
    fun returnsZeroWhenTargetEqualsX() {
        assertEquals(0, solution.leastOpsExpressTarget(3, 3))
    }

    @Test
    fun usesDivisionToExpressOne() {
        assertEquals(1, solution.leastOpsExpressTarget(2, 1))
    }
}
