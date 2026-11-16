package maximumbitwiseandafterincrementoperations

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumBitwiseAndAfterIncrementOperationsTest {
    @Test
    fun singleElement() {
        assertEquals(4, Solution().maximumAND(intArrayOf(1), 3, 1))
    }

    @Test
    fun twoElements() {
        assertEquals(2, Solution().maximumAND(intArrayOf(1, 2), 2, 2))
    }

    @Test
    fun noIncrementsNeeded() {
        assertEquals(7, Solution().maximumAND(intArrayOf(7, 7), 0, 2))
    }

    @Test
    fun limitedBudget() {
        assertEquals(5, Solution().maximumAND(intArrayOf(1, 2, 3), 5, 2))
    }

    @Test
    fun alreadyHigh() {
        assertEquals(5, Solution().maximumAND(intArrayOf(4, 5), 2, 2))
    }
}
