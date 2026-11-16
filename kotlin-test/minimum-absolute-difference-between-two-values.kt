package minimumabsolutedifferencebetweentwovalues

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumAbsoluteDifferenceBetweenTwoValuesTest {
    @Test
    fun adjacent() {
        assertEquals(1, Solution().minAbsoluteDifference(intArrayOf(0, 1, 2)))
    }

    @Test
    fun separated() {
        assertEquals(2, Solution().minAbsoluteDifference(intArrayOf(1, 0, 2)))
    }

    @Test
    fun reversed() {
        assertEquals(2, Solution().minAbsoluteDifference(intArrayOf(2, 0, 1)))
    }

    @Test
    fun noOne() {
        assertEquals(-1, Solution().minAbsoluteDifference(intArrayOf(0, 0, 0)))
    }

    @Test
    fun noTwo() {
        assertEquals(-1, Solution().minAbsoluteDifference(intArrayOf(1, 0, 0)))
    }

    @Test
    fun descending() {
        assertEquals(1, Solution().minAbsoluteDifference(intArrayOf(2, 1, 0)))
    }
}
