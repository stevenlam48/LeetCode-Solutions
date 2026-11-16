package trionicarrayii

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class TrionicArrayIiTest {
    @Test
    fun standardExample() {
        assertEquals(-4L, Solution().maxSumTrionic(intArrayOf(0, -2, -1, -3, 0, 2, -1)))
    }

    @Test
    fun keepsBestWindowAmongNegativePrefixes() {
        assertEquals(14L, Solution().maxSumTrionic(intArrayOf(1, 4, 2, 7)))
    }

    @Test
    fun equalValuesResetCandidateWindow() {
        assertEquals(7L, Solution().maxSumTrionic(intArrayOf(1, 1, 3, 1, 2)))
        assertEquals(Long.MIN_VALUE, Solution().maxSumTrionic(intArrayOf(1)))
    }
}
