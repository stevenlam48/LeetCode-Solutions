package maximizevalueoffunctioninaballpassinggame

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximizeValueOfFunctionInABallPassingGameTest {
    @Test
    fun exampleOne() {
        assertEquals(6L, Solution().getMaxFunctionValue(intArrayOf(2, 0, 1), 4))
    }

    @Test
    fun exampleTwo() {
        assertEquals(7L, Solution().getMaxFunctionValue(intArrayOf(1, 1, 1, 2, 2), 2))
    }

    @Test
    fun selfLoop() {
        assertEquals(0L, Solution().getMaxFunctionValue(intArrayOf(0), 5))
    }

    @Test
    fun twoNodeCycle() {
        assertEquals(2L, Solution().getMaxFunctionValue(intArrayOf(1, 0), 2))
    }
}
