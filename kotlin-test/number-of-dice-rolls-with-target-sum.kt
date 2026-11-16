package numberofdicerollswithtargetsum

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class NumberOfDiceRollsWithTargetSumTest {
    @Test
    fun example1() {
        assertEquals(1, Solution().numRollsToTarget(1, 6, 3))
    }

    @Test
    fun example2() {
        assertEquals(6, Solution().numRollsToTarget(2, 6, 7))
    }

    @Test
    fun example3() {
        assertEquals(1, Solution().numRollsToTarget(2, 5, 10))
    }

    @Test
    fun unreachableTarget() {
        assertEquals(0, Solution().numRollsToTarget(1, 2, 3))
    }

    @Test
    fun largeInputUsesModulo() {
        assertEquals(222616187, Solution().numRollsToTarget(30, 30, 500))
    }
}
