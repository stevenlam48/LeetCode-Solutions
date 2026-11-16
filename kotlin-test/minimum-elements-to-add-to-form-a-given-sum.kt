package minimumelementstoaddtoformagivensum

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumElementsToAddToFormAGivenSumTest {
    @Test
    fun example1() {
        assertEquals(2, Solution().minElements(intArrayOf(1, -1, 1), 3, -4))
    }

    @Test
    fun example2() {
        assertEquals(3, Solution().minElements(intArrayOf(1, 1, 1, 1), 3, 11))
    }

    @Test
    fun alreadyEqual() {
        assertEquals(0, Solution().minElements(intArrayOf(1, 2, 3), 5, 6))
    }

    @Test
    fun largeNegativeGoal() {
        assertEquals(1, Solution().minElements(intArrayOf(1, -10, 9, 1), 100, 0))
    }

    @Test
    fun singleLargeValue() {
        assertEquals(2, Solution().minElements(intArrayOf(0), 4, -7))
    }
}
