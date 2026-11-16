package delayedcountofequalelements

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class DelayedCountOfEqualElementsTest {
    private val solution = Solution()

    @Test
    fun countsLaterEqualElementsAtDelay() {
        assertArrayEquals(intArrayOf(1, 1, 0, 0, 0, 0), solution.delayedCount(intArrayOf(1, 2, 1, 3, 1, 2), 2))
    }

    @Test
    fun immediateNextElement() {
        assertArrayEquals(intArrayOf(1, 0, 0, 0), solution.delayedCount(intArrayOf(4, 4, 4, 5), 1))
    }

    @Test
    fun remainingTailIsZero() {
        assertArrayEquals(intArrayOf(0, 0, 0), solution.delayedCount(intArrayOf(1, 1, 1), 3))
    }

    @Test
    fun emptyInput() {
        assertArrayEquals(IntArray(0), solution.delayedCount(IntArray(0), 0))
    }
}
