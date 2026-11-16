package maximumcoinsheroescancollect

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MaximumCoinsHeroesCanCollectTest {
    @Test
    fun example() {
        assertArrayEquals(
            longArrayOf(3, 6, 6),
            Solution().maximumCoins(intArrayOf(1, 4, 2), intArrayOf(1, 1, 2), intArrayOf(1, 2, 3))
        )
    }

    @Test
    fun oneHeroBeatsAllMonsters() {
        assertArrayEquals(
            longArrayOf(6),
            Solution().maximumCoins(intArrayOf(5), intArrayOf(1, 2, 3), intArrayOf(1, 2, 3))
        )
    }

    @Test
    fun heroTooWeak() {
        assertArrayEquals(
            longArrayOf(100),
            Solution().maximumCoins(intArrayOf(10), intArrayOf(1), intArrayOf(100))
        )
    }
}
