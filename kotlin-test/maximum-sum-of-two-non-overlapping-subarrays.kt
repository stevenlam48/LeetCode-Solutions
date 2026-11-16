package maximumsumoftwononoverlappingsubarrays

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumSumOfTwoNonOverlappingSubarraysTest {
    private val solution = Solution()

    @Test
    fun firstExample() {
        assertEquals(
            20,
            solution.maxSumTwoNoOverlap(intArrayOf(0, 6, 5, 2, 2, 5, 1, 9, 4), 1, 2)
        )
    }

    @Test
    fun secondExample() {
        assertEquals(
            29,
            solution.maxSumTwoNoOverlap(intArrayOf(3, 8, 1, 3, 2, 1, 8, 9, 0), 3, 2)
        )
    }

    @Test
    fun thirdExample() {
        assertEquals(
            31,
            solution.maxSumTwoNoOverlap(intArrayOf(2, 1, 5, 6, 0, 9, 5, 0, 3, 8), 4, 3)
        )
    }

    @Test
    fun twoElements() {
        assertEquals(3, solution.maxSumTwoNoOverlap(intArrayOf(1, 2), 1, 1))
    }
}
