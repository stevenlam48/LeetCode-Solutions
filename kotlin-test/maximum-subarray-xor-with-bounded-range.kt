package maximumsubarrayxorwithboundedrange
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumSubarrayXorWithBoundedRangeTest {
    private val solution = Solution()

    @Test
    fun allElementsCanBelongToOneSubarray() {
        assertEquals(3, solution.maxXor(intArrayOf(1, 2, 3), 2))
    }

    @Test
    fun boundedRangeSelectsLaterWindow() {
        assertEquals(13, solution.maxXor(intArrayOf(9, 10, 11, 12), 2))
    }

    @Test
    fun duplicateValuesWithZeroRange() {
        assertEquals(4, solution.maxXor(intArrayOf(4, 4, 4), 0))
    }

    @Test
    fun allZeros() {
        assertEquals(0, solution.maxXor(intArrayOf(0, 0, 0), 0))
    }

    @Test
    fun singleElement() {
        assertEquals(9, solution.maxXor(intArrayOf(9), 0))
    }
}
