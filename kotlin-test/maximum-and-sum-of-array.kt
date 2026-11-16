package maximumandsumofarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumAndSumOfArrayTest {
    private val solution = Solution()

    @Test
    fun leetCodeExample() {
        assertEquals(9, solution.maximumANDSum(intArrayOf(1, 2, 3, 4, 5, 6), 3))
    }

    @Test
    fun missingNumbersArePaddedWithZero() {
        assertEquals(2, solution.maximumANDSum(intArrayOf(1, 0, 1), 2))
    }

    @Test
    fun oneSlotHasCapacityTwo() {
        assertEquals(1, solution.maximumANDSum(intArrayOf(5), 1))
    }

    @Test
    fun assignBothNumbersToSecondSlot() {
        assertEquals(4, solution.maximumANDSum(intArrayOf(8, 7, 6), 2))
    }

    @Test
    fun emptyArray() {
        assertEquals(0, solution.maximumANDSum(intArrayOf(), 2))
    }
}
