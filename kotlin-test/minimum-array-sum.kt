package minimumarraysum

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumArraySumTest {
    @Test
    fun standardExample() = assertEquals(23, Solution().minArraySum(intArrayOf(2, 8, 3, 19, 3), 3, 1, 1))

    @Test
    fun multipleHalvingOperations() = assertEquals(3, Solution().minArraySum(intArrayOf(2, 4, 3), 3, 2, 1))

    @Test
    fun noOperations() = assertEquals(9, Solution().minArraySum(intArrayOf(2, 4, 3), 3, 0, 0))

    @Test
    fun subtractionOnEveryElement() = assertEquals(1, Solution().minArraySum(intArrayOf(1, 2), 1, 0, 2))
}
