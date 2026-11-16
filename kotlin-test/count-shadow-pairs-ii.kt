package countshadowpairsii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountShadowPairsIITest {
    private val solution = Solution()

    @Test
    fun increasingValues() {
        assertEquals(2, solution.shadowPairs(intArrayOf(1, 2, 3)))
    }

    @Test
    fun decreasingValues() {
        assertEquals(0, solution.shadowPairs(intArrayOf(3, 2, 1)))
    }

    @Test
    fun multipleMergeLevels() {
        assertEquals(1, solution.shadowPairs(intArrayOf(3, 1, 2)))
    }

    @Test
    fun duplicateValuesShareOneGroup() {
        assertEquals(0, solution.shadowPairs(intArrayOf(2, 2, 2)))
        assertEquals(2, solution.shadowPairs(intArrayOf(1, 1, 2)))
    }
}
