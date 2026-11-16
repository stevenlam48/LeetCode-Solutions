package teemoattacking

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TeemoAttackingTest {
    @Test
    fun standardExamples() {
        assertEquals(4, Solution().findPoisonedDuration(intArrayOf(1, 4), 2))
        assertEquals(3, Solution().findPoisonedDuration(intArrayOf(1, 2), 2))
    }

    @Test
    fun emptySeries() {
        assertEquals(0, Solution().findPoisonedDuration(intArrayOf(), 5))
    }

    @Test
    fun overlappingAndSeparatedAttacks() {
        assertEquals(9, Solution().findPoisonedDuration(intArrayOf(1, 3, 6), 4))
    }
}
