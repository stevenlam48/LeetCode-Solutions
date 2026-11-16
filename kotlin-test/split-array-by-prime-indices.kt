package splitarraybyprimeindices

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SplitArrayByPrimeIndicesTest {
    @Test
    fun mixedPrimeAndNonPrimeIndices() {
        assertEquals(2L, Solution().splitArray(intArrayOf(2, 3, 4, 5, 6)))
    }

    @Test
    fun negativeValuesPreserveAbsoluteDifference() {
        assertEquals(5L, Solution().splitArray(intArrayOf(-1, 2, -3, 4, -5)))
    }

    @Test
    fun singleElementIsSubtracted() {
        assertEquals(8L, Solution().splitArray(intArrayOf(8)))
    }

    @Test
    fun emptyArrayHasZeroDifference() {
        assertEquals(0L, Solution().splitArray(intArrayOf()))
    }

    @Test
    fun valuesCanExceedIntAccumulatorRange() {
        val nums = IntArray(2) { Int.MAX_VALUE }
        assertEquals(4_294_967_294L, Solution().splitArray(nums))
    }
}
