package minimuminitialstrengthtodefeatallmonsters

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumInitialStrengthToDefeatAllMonstersTest {
    private val solution = Solution()

    @Test
    fun noBoostsRequiresTotalMonsterStrength() {
        assertEquals(10L, solution.minInitialStrength(intArrayOf(3, 5, 2), emptyArray()))
    }

    @Test
    fun singleMonsterWithExactBoost() {
        assertEquals(0L, solution.minInitialStrength(intArrayOf(4), arrayOf(intArrayOf(0, 0, 4))))
    }

    @Test
    fun boostCanCoverTheFinalMonster() {
        assertEquals(
            14L,
            solution.minInitialStrength(intArrayOf(5, 7, 6), arrayOf(intArrayOf(0, 2, 4)))
        )
    }

    @Test
    fun zeroThresholdSkipsTheNextBoostDelta() {
        assertEquals(
            3L,
            solution.minInitialStrength(intArrayOf(2, 4, 3), arrayOf(intArrayOf(1, 2, 3)))
        )
    }

    @Test
    fun overlappingBoostsAreAccumulatedBackward() {
        assertEquals(
            11L,
            solution.minInitialStrength(
                intArrayOf(4, 6, 3),
                arrayOf(intArrayOf(0, 1, 3), intArrayOf(1, 2, 2))
            )
        )
    }
}
