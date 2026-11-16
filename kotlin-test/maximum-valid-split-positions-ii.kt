package maximumvalidsplitpositionsii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumValidSplitPositionsIiTest {
    @Test
    fun removalCreatesValidSplit() {
        assertEquals(1, Solution().maxValidSplits(intArrayOf(2, 2, 3)))
        assertEquals(1, Solution().maxValidSplits(intArrayOf(2, 2, 3, 6)))
    }

    @Test
    fun existingSplitsAreRetained() {
        assertEquals(2, Solution().maxValidSplits(intArrayOf(7, 7, 7)))
        assertEquals(1, Solution().maxValidSplits(intArrayOf(6, 3, 9, 12)))
    }

    @Test
    fun noValidSplits() {
        assertEquals(0, Solution().maxValidSplits(intArrayOf(2, 4, 8)))
        assertEquals(0, Solution().maxValidSplits(intArrayOf(6, 10, 15)))
    }
}
