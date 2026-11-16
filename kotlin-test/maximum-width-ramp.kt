package maximumwidthramp

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumWidthRampTest {
    private val solution = Solution()

    @Test
    fun exampleOne() {
        assertEquals(4, solution.maxWidthRamp(intArrayOf(6, 0, 8, 2, 1, 5)))
    }

    @Test
    fun exampleTwo() {
        assertEquals(7, solution.maxWidthRamp(intArrayOf(9, 8, 1, 0, 1, 9, 4, 0, 4, 1)))
    }

    @Test
    fun decreasingPairHasNoRamp() {
        assertEquals(0, solution.maxWidthRamp(intArrayOf(1, 0)))
    }

    @Test
    fun increasingPair() {
        assertEquals(1, solution.maxWidthRamp(intArrayOf(0, 1)))
    }

    @Test
    fun allEqual() {
        assertEquals(2, solution.maxWidthRamp(intArrayOf(1, 1, 1)))
    }
}
