package smallestmissingnonnegativeintegerafteroperations

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SmallestMissingNonNegativeIntegerAfterOperationsTest {
    private val solution = Solution()

    @Test
    fun examples() {
        assertEquals(4, solution.findSmallestInteger(intArrayOf(1, -10, 7, 13, 6, 8), 5))
        assertEquals(2, solution.findSmallestInteger(intArrayOf(1, -10, 7, 13, 6, 8), 7))
    }

    @Test
    fun zeroValue() {
        assertEquals(3, solution.findSmallestInteger(intArrayOf(0, 0, 0), 1))
    }

    @Test
    fun negativeNumbers() {
        assertEquals(3, solution.findSmallestInteger(intArrayOf(-1, -2, -3), 3))
    }
}
