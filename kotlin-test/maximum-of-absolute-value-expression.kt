package maximumofabsolutevalueexpression

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MaximumOfAbsoluteValueExpressionTest {
    @Test
    fun firstExample() {
        assertEquals(13, Solution().maxAbsValExpr(intArrayOf(1, 2, 3, 4), intArrayOf(-1, 4, 5, 6)))
    }

    @Test
    fun secondExample() {
        assertEquals(20, Solution().maxAbsValExpr(intArrayOf(1, -2, -5, 0, 10), intArrayOf(0, -2, -1, -7, -4)))
    }

    @Test
    fun singleElement() {
        assertEquals(0, Solution().maxAbsValExpr(intArrayOf(7), intArrayOf(-3)))
    }

    @Test
    fun constantArraysUseIndexDistance() {
        assertEquals(3, Solution().maxAbsValExpr(intArrayOf(4, 4, 4, 4), intArrayOf(-2, -2, -2, -2)))
    }
}
