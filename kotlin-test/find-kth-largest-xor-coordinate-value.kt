package findkthlargestxorcoordinatevalue

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindKthLargestXorCoordinateValueTest {
    @Test
    fun findsEveryRankOfCoordinateXorValues() {
        val sortedRanks = intArrayOf(7, 5, 4, 0)
        for (k in 1..4) {
            val matrix = arrayOf(intArrayOf(5, 2), intArrayOf(1, 6))
            assertEquals(sortedRanks[k - 1], Solution().kthLargestValue(matrix, k))
        }
    }

    @Test
    fun handlesSingleCellMatrix() {
        assertEquals(9, Solution().kthLargestValue(arrayOf(intArrayOf(9)), 1))
    }

    @Test
    fun handlesDuplicateXorValues() {
        assertEquals(1, Solution().kthLargestValue(arrayOf(intArrayOf(1, 1), intArrayOf(1, 1)), 1))
        assertEquals(0, Solution().kthLargestValue(arrayOf(intArrayOf(1, 1), intArrayOf(1, 1)), 4))
    }
}
