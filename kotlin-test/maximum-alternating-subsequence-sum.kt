package maximumalternatingsubsequencesum

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumAlternatingSubsequenceSumTest {
    private val solution = Solution()

    @Test
    fun firstExample() {
        assertEquals(7L, solution.maxAlternatingSum(intArrayOf(4, 2, 5, 3)))
    }

    @Test
    fun secondExample() {
        assertEquals(8L, solution.maxAlternatingSum(intArrayOf(5, 6, 7, 8)))
    }

    @Test
    fun decreasingExample() {
        assertEquals(10L, solution.maxAlternatingSum(intArrayOf(6, 2, 1, 2, 4, 5)))
    }

    @Test
    fun singleElement() {
        assertEquals(9L, solution.maxAlternatingSum(intArrayOf(9)))
    }

    @Test
    fun flatArray() {
        assertEquals(3L, solution.maxAlternatingSum(intArrayOf(3, 3, 3, 3)))
    }
}
