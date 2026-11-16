package earliestsecondtomarkindicesi

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class EarliestSecondToMarkIndicesITest {
    @Test
    fun allZeroImmediate() {
        assertEquals(2, Solution().earliestSecondToMarkIndices(intArrayOf(0, 0), intArrayOf(1, 2)))
    }

    @Test
    fun oneDecrement() {
        assertEquals(3, Solution().earliestSecondToMarkIndices(intArrayOf(1, 0), intArrayOf(1, 2, 1, 2)))
    }

    @Test
    fun twoDecrements() {
        assertEquals(4, Solution().earliestSecondToMarkIndices(intArrayOf(1, 1), intArrayOf(1, 2, 1, 2)))
    }

    @Test
    fun impossible() {
        assertEquals(-1, Solution().earliestSecondToMarkIndices(intArrayOf(0, 1), intArrayOf(2, 2, 2)))
    }
}
