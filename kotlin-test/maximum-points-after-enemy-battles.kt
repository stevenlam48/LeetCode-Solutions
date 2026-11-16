package maximumpointsafterenemybattles

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MaximumPointsAfterEnemyBattlesTest {
    @Test
    fun standardCase() {
        assertEquals(3L, Solution().maximumPoints(intArrayOf(3, 2, 2), 2))
    }

    @Test
    fun canUseRemainingEnergy() {
        assertEquals(5L, Solution().maximumPoints(intArrayOf(2, 3, 4), 3))
    }

    @Test
    fun insufficientInitialEnergy() {
        assertEquals(0L, Solution().maximumPoints(intArrayOf(3, 2, 2), 1))
    }

    @Test
    fun singleEnemy() {
        assertEquals(2L, Solution().maximumPoints(intArrayOf(5), 10))
    }
}
