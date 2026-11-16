package minimumamountofdamagedealttobob

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumAmountOfDamageDealtToBobTest {
    @Test
    fun prioritizeDamageRate() {
        val health = intArrayOf(4, 6)
        assertEquals(11L, Solution().minDamage(2, intArrayOf(1, 2), health))
        assertEquals(2, health[0])
        assertEquals(3, health[1])
    }

    @Test
    fun singleEnemyRoundsHealthUp() = assertEquals(28L, Solution().minDamage(3, intArrayOf(7), intArrayOf(10)))

    @Test
    fun equalRatiosHaveSameDamage() = assertEquals(42L, Solution().minDamage(1, intArrayOf(2, 4), intArrayOf(3, 6)))

    @Test
    fun threeEnemies() = assertEquals(27L, Solution().minDamage(1, intArrayOf(3, 1, 2), intArrayOf(2, 6, 3)))
}
