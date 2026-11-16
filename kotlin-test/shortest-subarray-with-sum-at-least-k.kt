package shortestsubarraywithsumatleastk

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ShortestSubarrayWithSumAtLeastKTest {
    @Test
    fun findsSingleElement() {
        assertEquals(1, Solution().shortestSubarray(intArrayOf(1), 1))
    }

    @Test
    fun returnsMinusOneWhenSumIsTooSmall() {
        assertEquals(-1, Solution().shortestSubarray(intArrayOf(1, 2), 4))
    }

    @Test
    fun handlesNegativeNumbers() {
        assertEquals(3, Solution().shortestSubarray(intArrayOf(2, -1, 2), 3))
        assertEquals(3, Solution().shortestSubarray(intArrayOf(3, -1, 4), 6))
    }

    @Test
    fun picksShortestSuffixOfPositiveArray() {
        assertEquals(3, Solution().shortestSubarray(intArrayOf(1, 2, 3, 4, 5), 11))
    }

    @Test
    fun findsWindowEndingInsideArray() {
        assertEquals(3, Solution().shortestSubarray(intArrayOf(84, -37, 32, 40, 95), 167))
    }

    @Test
    fun handlesAllNegativeInput() {
        assertEquals(-1, Solution().shortestSubarray(intArrayOf(-1, -2, -3), 1))
    }
}
