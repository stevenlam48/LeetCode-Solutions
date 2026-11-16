package maximumdistanceinarrays
// Time:  O(n)
// Space: O(1)

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumDistanceInArraysTest {
    private val solution = Solution()

    @Test
    fun findsDistanceAcrossDifferentArrays() {
        val arrays = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5),
            intArrayOf(1, 2, 3)
        )
        assertEquals(4, solution.maxDistance(arrays))
    }

    @Test
    fun singleElementArraysCanHaveZeroDistance() {
        assertEquals(0, solution.maxDistance(arrayOf(intArrayOf(1), intArrayOf(1))))
    }

    @Test
    fun considersBothExtremeCombinations() {
        val arrays = arrayOf(intArrayOf(1, 4), intArrayOf(0, 5))
        assertEquals(4, solution.maxDistance(arrays))
    }

    @Test
    fun handlesNegativeValues() {
        val arrays = arrayOf(
            intArrayOf(-10, -5),
            intArrayOf(-3, 0),
            intArrayOf(2, 4)
        )
        assertEquals(14, solution.maxDistance(arrays))
    }
}
