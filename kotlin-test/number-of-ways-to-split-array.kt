package numberofwaystosplitarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfWaysToSplitArrayTest {
    @Test
    fun firstExample() {
        assertEquals(2, Solution().waysToSplitArray(intArrayOf(10, 4, -8, 7)))
    }

    @Test
    fun secondExample() {
        assertEquals(2, Solution().waysToSplitArray(intArrayOf(2, 3, 1, 0)))
    }

    @Test
    fun negativeValues() {
        assertEquals(2, Solution().waysToSplitArray(intArrayOf(-1, -2, -3)))
    }

    @Test
    fun emptyInput() {
        assertEquals(0, Solution().waysToSplitArray(intArrayOf()))
    }
}
