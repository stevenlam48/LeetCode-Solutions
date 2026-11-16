package validkuniquesubarraysii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ValidKUniqueSubarraysIITest {
    @Test
    fun firstQueryIsInvalid() {
        assertEquals(
            listOf(false, true, true, true, true),
            Solution().validSubarrays(intArrayOf(1, 2, 1, 2), 2, 1, 2, 5)
        )
    }

    @Test
    fun queriesGrowTowardsValidRange() {
        assertEquals(
            listOf(false, false, true, true, true, true),
            Solution().validSubarrays(intArrayOf(1, 2, 2, 1, 3, 3), 2, 1, 4, 6)
        )
    }

    @Test
    fun kEqualsOne() {
        assertEquals(
            listOf(true, true, true),
            Solution().validSubarrays(intArrayOf(1, 1, 2, 2), 1, 0, 1, 3)
        )
    }

    @Test
    fun singleQuery() {
        assertEquals(
            listOf(false),
            Solution().validSubarrays(intArrayOf(7, 7, 7), 2, 0, 2, 1)
        )
    }
}
