package countshadowpairsi

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountShadowPairsITest {
    private val solution = Solution()

    @Test
    fun increasingValues() {
        assertEquals(3L, solution.shadowPairs(intArrayOf(1, 2, 3)))
    }

    @Test
    fun decreasingValues() {
        assertEquals(0L, solution.shadowPairs(intArrayOf(3, 2, 1)))
    }

    @Test
    fun poppedValuesAreNotCounted() {
        assertEquals(1L, solution.shadowPairs(intArrayOf(3, 1, 2)))
    }

    @Test
    fun duplicateValues() {
        assertEquals(0L, solution.shadowPairs(intArrayOf(2, 2, 2)))
    }
}
