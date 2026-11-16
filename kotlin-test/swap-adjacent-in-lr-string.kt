package swapadjacentinlrstring

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SwapAdjacentInLrStringTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertTrue(solution.canTransform("RXXLRXRXL", "XRLXXRRLX"))
    }

    @Test
    fun testExample2() {
        assertFalse(solution.canTransform("X", "L"))
    }

    @Test
    fun testExample3() {
        assertFalse(solution.canTransform("LLR", "RRL"))
    }

    @Test
    fun testIdentical() {
        assertTrue(solution.canTransform("X", "X"))
    }

    @Test
    fun testLeftCannotMoveRight() {
        assertFalse(solution.canTransform("LXX", "XXL"))
    }
}
