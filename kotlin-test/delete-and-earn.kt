package deleteandearn

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DeleteAndEarnTest {
    private val solution = Solution()

    @Test
    fun skippingAdjacentValuesEarnsMore() {
        assertEquals(6, solution.deleteAndEarn(intArrayOf(3, 4, 2)))
    }

    @Test
    fun repeatedValues() {
        assertEquals(9, solution.deleteAndEarn(intArrayOf(2, 2, 3, 3, 3, 4)))
    }

    @Test
    fun emptyInput() {
        assertEquals(0, solution.deleteAndEarn(IntArray(0)))
    }

    @Test
    fun zerosAndMaximumValue() {
        assertEquals(10000, solution.deleteAndEarn(intArrayOf(0, 0, 10000)))
    }
}
