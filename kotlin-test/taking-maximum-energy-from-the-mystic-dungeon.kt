package takingmaximumenergyfromthemysticdungeon

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TakingMaximumEnergyFromTheMysticDungeonTest {
    @Test
    fun standardExamples() {
        assertEquals(3, Solution().maximumEnergy(intArrayOf(5, 2, -10, -5, 1), 3))
        assertEquals(-1, Solution().maximumEnergy(intArrayOf(-2, -3, -1), 2))
    }

    @Test
    fun singleJump() {
        assertEquals(7, Solution().maximumEnergy(intArrayOf(1, 2, 7, -5), 4))
    }

    @Test
    fun negativePathValues() {
        assertEquals(-2, Solution().maximumEnergy(intArrayOf(-8, -2, -3), 2))
    }
}
