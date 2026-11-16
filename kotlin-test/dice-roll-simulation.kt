package dicerollsimulation

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DiceRollSimulationTest {
    private val solution = Solution()

    @Test
    fun twoRollsWithMixedLimits() {
        assertEquals(34, solution.dieSimulator(2, intArrayOf(1, 1, 2, 2, 2, 3)))
    }

    @Test
    fun twoRollsWithoutConsecutiveDuplicates() {
        assertEquals(30, solution.dieSimulator(2, intArrayOf(1, 1, 1, 1, 1, 1)))
    }

    @Test
    fun threeRollsWithMixedLimits() {
        assertEquals(181, solution.dieSimulator(3, intArrayOf(1, 1, 1, 2, 2, 3)))
    }

    @Test
    fun oneRollHasSixSequences() {
        assertEquals(6, solution.dieSimulator(1, intArrayOf(1, 2, 2, 3, 3, 4)))
    }

    @Test
    fun threeRollsCannotRepeatWhenAllLimitsAreOne() {
        assertEquals(150, solution.dieSimulator(3, IntArray(6) { 1 }))
    }
}
