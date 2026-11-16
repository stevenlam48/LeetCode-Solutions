package minimumarraylengthafterpairremovals

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumArrayLengthAfterPairRemovalsTest {
    @Test
    fun allPairsRemoved() = assertEquals(0, Solution().minLengthAfterRemovals(intArrayOf(1, 1, 2, 2, 3, 4, 2, 3)))

    @Test
    fun dominantValue() = assertEquals(2, Solution().minLengthAfterRemovals(intArrayOf(1, 1, 1, 1, 2, 3)))

    @Test
    fun singleValueOddLength() = assertEquals(5, Solution().minLengthAfterRemovals(intArrayOf(7, 7, 7, 7, 7)))

    @Test
    fun distinctValuesOddLength() = assertEquals(1, Solution().minLengthAfterRemovals(intArrayOf(1, 2, 3)))
}
