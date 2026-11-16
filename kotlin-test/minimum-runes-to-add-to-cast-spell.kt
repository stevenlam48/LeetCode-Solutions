package minimumrunestoaddtocastspell

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumRunesToAddToCastSpellTest {
    @Test
    fun isolatedNode() {
        assertEquals(1, Solution().minRunesToAdd(1, intArrayOf(), intArrayOf(), intArrayOf()))
    }

    @Test
    fun sourceHasCrystal() {
        assertEquals(0, Solution().minRunesToAdd(2, intArrayOf(0), intArrayOf(0), intArrayOf(1)))
    }

    @Test
    fun singleSourceWithoutCrystal() {
        assertEquals(1, Solution().minRunesToAdd(2, intArrayOf(), intArrayOf(0), intArrayOf(1)))
    }

    @Test
    fun singleCycle() {
        assertEquals(
            1,
            Solution().minRunesToAdd(
                3, intArrayOf(), intArrayOf(0, 1, 2), intArrayOf(1, 2, 0)
            )
        )
    }

    @Test
    fun twoSources() {
        assertEquals(
            2,
            Solution().minRunesToAdd(
                3, intArrayOf(), intArrayOf(0, 2), intArrayOf(1, 1)
            )
        )
    }

    @Test
    fun oneSourceCoveredByCrystal() {
        assertEquals(
            1,
            Solution().minRunesToAdd(
                3, intArrayOf(2), intArrayOf(0, 2), intArrayOf(1, 1)
            )
        )
    }
}
