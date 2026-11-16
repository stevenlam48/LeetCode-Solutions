package successfulpairsofspellsandpotions

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SuccessfulPairsOfSpellsAndPotionsTest {
    @Test
    fun exampleOne() {
        assertArrayEquals(
            intArrayOf(4, 0, 3),
            Solution().successfulPairs(intArrayOf(5, 1, 3), intArrayOf(1, 2, 3, 4, 5), 7L)
        )
    }

    @Test
    fun exampleTwo() {
        assertArrayEquals(
            intArrayOf(2, 0, 2),
            Solution().successfulPairs(intArrayOf(3, 1, 2), intArrayOf(8, 5, 8), 16L)
        )
    }

    @Test
    fun exactProductCounts() {
        assertArrayEquals(
            intArrayOf(1, 1),
            Solution().successfulPairs(intArrayOf(2, 3), intArrayOf(4), 8L)
        )
    }

    @Test
    fun emptySpells() {
        assertArrayEquals(
            intArrayOf(),
            Solution().successfulPairs(intArrayOf(), intArrayOf(3, 1), 1L)
        )
    }
}
