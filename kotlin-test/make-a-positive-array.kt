package makeapositivearray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MakeAPositiveArrayTest {
    @Test
    fun alreadyPositiveArrayNeedsNoChanges() {
        assertEquals(0, Solution().makeArrayPositive(intArrayOf(2, 3, 4, 5)))
    }

    @Test
    fun repairsNonPositivePrefix() {
        assertEquals(1, Solution().makeArrayPositive(intArrayOf(1, -4, 3, 0)))
    }

    @Test
    fun comparesAgainstEarlierPrefixMinimum() {
        assertEquals(1, Solution().makeArrayPositive(intArrayOf(2, -5, 4, -3, 2)))
    }

    @Test
    fun handlesLengthTwoAndAllZeroInputs() {
        assertEquals(0, Solution().makeArrayPositive(intArrayOf(-5, 5)))
        assertEquals(1, Solution().makeArrayPositive(intArrayOf(0, 0, 0)))
    }
}
