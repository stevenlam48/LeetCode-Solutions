package calculatescoreafterperforminginstructions

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CalculateScoreAfterPerformingInstructionsTest {
    @Test
    fun leetCodeExample() {
        val instructions = arrayOf("jump", "add", "add", "jump", "add", "jump")
        assertEquals(1L, Solution().calculateScore(instructions, intArrayOf(2, 1, 3, 1, -2, -3)))
    }

    @Test
    fun repeatedJumpStopsExecution() {
        assertEquals(5L, Solution().calculateScore(arrayOf("add", "jump"), intArrayOf(5, 0)))
    }

    @Test
    fun negativeJumpLeavesArray() {
        assertEquals(0L, Solution().calculateScore(arrayOf("jump"), intArrayOf(-1)))
    }

    @Test
    fun negativeValuesAndPositiveJump() {
        val instructions = arrayOf("add", "add", "jump")
        assertEquals(-1L, Solution().calculateScore(instructions, intArrayOf(2, -3, 5)))
    }
}
