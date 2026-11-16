package minimumthresholdforinversionpairscount

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MinimumThresholdForInversionPairsCountTest {
    private val solution = Solution()

    @Test
    fun testBasicThreshold() {
        assertEquals(3, solution.minThreshold(intArrayOf(5, 1, 4, 2), 3))
        assertEquals(1, solution.minThreshold(intArrayOf(3, 2, 1), 2))
    }

    @Test
    fun testImpossible() {
        assertEquals(-1, solution.minThreshold(intArrayOf(2, 1, 3), 2))
        assertEquals(-1, solution.minThreshold(intArrayOf(1, 2, 3, 4), 3))
    }

    @Test
    fun testZeroPairs() {
        assertEquals(0, solution.minThreshold(intArrayOf(1, 2), 0))
        assertEquals(0, solution.minThreshold(intArrayOf(7), 0))
    }

    @Test
    fun testAllPairs() {
        assertEquals(2, solution.minThreshold(intArrayOf(3, 2, 1), 3))
        assertEquals(4, solution.minThreshold(intArrayOf(5, 1, 4, 2), 4))
        assertEquals(-1, solution.minThreshold(intArrayOf(5, 1, 4, 2), 5))
    }
}
