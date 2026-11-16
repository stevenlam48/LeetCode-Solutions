package targetsum

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TargetSumTest {
    @Test
    fun standardExample() {
        assertEquals(5, Solution().findTargetSumWays(intArrayOf(1, 1, 1, 1, 1), 3))
    }

    @Test
    fun singleElementBothSigns() {
        assertEquals(1, Solution().findTargetSumWays(intArrayOf(1), 1))
        assertEquals(1, Solution().findTargetSumWays(intArrayOf(1), -1))
    }

    @Test
    fun impossibleTargets() {
        assertEquals(0, Solution().findTargetSumWays(intArrayOf(1, 2, 3), 1))
        assertEquals(0, Solution().findTargetSumWays(intArrayOf(1, 1), 3))
    }

    @Test
    fun zerosCreateMultipleWays() {
        assertEquals(4, Solution().findTargetSumWays(intArrayOf(0, 0, 1), 1))
    }
}
