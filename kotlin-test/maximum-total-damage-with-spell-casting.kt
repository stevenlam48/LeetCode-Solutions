package maximumtotaldamagewithspellcasting

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumTotalDamageWithSpellCastingTest {
    private val solution = Solution()

    @Test
    fun standardExample() {
        assertEquals(6L, solution.maximumTotalDamage(intArrayOf(1, 1, 3, 4)))
    }

    @Test
    fun duplicatesAndGap() {
        assertEquals(13L, solution.maximumTotalDamage(intArrayOf(7, 1, 6, 6)))
    }

    @Test
    fun consecutivePowers() {
        assertEquals(3L, solution.maximumTotalDamage(intArrayOf(1, 2, 3)))
    }

    @Test
    fun singleSpell() {
        assertEquals(5L, solution.maximumTotalDamage(intArrayOf(5)))
    }

    @Test
    fun allDuplicates() {
        assertEquals(3L, solution.maximumTotalDamage(intArrayOf(1, 1, 1)))
    }
}
