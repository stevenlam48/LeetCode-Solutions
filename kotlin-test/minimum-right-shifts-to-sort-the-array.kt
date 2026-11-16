package minimumrightshiftstosortthearray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumRightShiftsToSortTheArrayTest {
    @Test
    fun example1() {
        assertEquals(2, Solution().minimumRightShifts(intArrayOf(3, 4, 5, 1, 2)))
    }

    @Test
    fun alreadySorted() {
        assertEquals(0, Solution().minimumRightShifts(intArrayOf(1, 3, 5)))
    }

    @Test
    fun impossible() {
        assertEquals(-1, Solution().minimumRightShifts(intArrayOf(2, 1, 4)))
    }

    @Test
    fun singleElement() {
        assertEquals(0, Solution().minimumRightShifts(intArrayOf(1)))
    }

    @Test
    fun twoElements() {
        assertEquals(1, Solution().minimumRightShifts(intArrayOf(2, 1)))
    }

    @Test
    fun duplicatesAreNotStrictlyIncreasing() {
        assertEquals(-1, Solution().minimumRightShifts(intArrayOf(1, 1)))
    }
}
