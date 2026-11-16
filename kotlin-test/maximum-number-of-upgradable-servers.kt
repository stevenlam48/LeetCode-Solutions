package maximumnumberofupgradableservers

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MaximumnumberofupgradableserversTest {
    @Test
    fun example1() {
        val count = intArrayOf(3, 2, 2)
        val upgrade = intArrayOf(1, 2, 3)
        val sell = intArrayOf(1, 1, 1)
        val money = intArrayOf(1, 3, 2)
        assertArrayEquals(intArrayOf(2, 1, 1), Solution().maxUpgrades(count, upgrade, sell, money))
    }

    @Test
    fun cannotUpgradeAnything() {
        val count = intArrayOf(0, 1, 2, 3)
        val upgrade = intArrayOf(1, 2, 3, 4)
        val sell = intArrayOf(1, 1, 1, 1)
        val money = intArrayOf(1, 1, 1, 1)
        assertArrayEquals(intArrayOf(0, 0, 0, 0), Solution().maxUpgrades(count, upgrade, sell, money))
    }

    @Test
    fun enoughMoneyForEverything() {
        assertArrayEquals(
            intArrayOf(1),
            Solution().maxUpgrades(intArrayOf(1), intArrayOf(1), intArrayOf(1), intArrayOf(10))
        )
    }

    @Test
    fun oneSellFinancesUpgrade() {
        assertArrayEquals(
            intArrayOf(1),
            Solution().maxUpgrades(intArrayOf(2), intArrayOf(1), intArrayOf(1), intArrayOf(0))
        )
    }
}
