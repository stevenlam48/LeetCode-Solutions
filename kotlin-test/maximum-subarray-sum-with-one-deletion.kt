package maximumsubarraysumwithonedeletion
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumSubarraySumWithOneDeletionTest {
    private val solution = Solution()

    @Test
    fun deletingNegativeMiddleElement() {
        assertEquals(4, solution.maximumSum(intArrayOf(1, -2, 0, 3)))
    }

    @Test
    fun keepingAllElementsIsBetter() {
        assertEquals(3, solution.maximumSum(intArrayOf(1, -2, -2, 3)))
    }

    @Test
    fun allNegativeElements() {
        assertEquals(-1, solution.maximumSum(intArrayOf(-1, -1, -1, -1)))
    }

    @Test
    fun singleElement() {
        assertEquals(-5, solution.maximumSum(intArrayOf(-5)))
    }

    @Test
    fun deletionAtInteriorValley() {
        assertEquals(23, solution.maximumSum(intArrayOf(8, 6, -7, 9)))
    }
}
