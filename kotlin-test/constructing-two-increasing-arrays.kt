package constructingtwoincreasingarrays

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ConstructingTwoIncreasingArraysTest {
    @Test
    fun equalOddValuesRequireAnOddGap() {
        assertEquals(3, Solution().minLargest(intArrayOf(1), intArrayOf(1)))
    }

    @Test
    fun evenThenOddValuesUseConsecutiveNumbers() {
        assertEquals(2, Solution().minLargest(intArrayOf(2), intArrayOf(3)))
    }

    @Test
    fun emptyInputsHaveZeroAsTheirLastValue() {
        assertEquals(0, Solution().minLargest(intArrayOf(), intArrayOf()))
    }

    @Test
    fun oneEmptyInputStillBuildsTheOtherSequence() {
        assertEquals(1, Solution().minLargest(intArrayOf(), intArrayOf(1)))
    }
}
