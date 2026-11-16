package maxdotproductoftwosubsequences

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaxDotProductOfTwoSubsequencesTest {
    private val solution = Solution()

    @Test
    fun computesFirstExample() {
        assertEquals(18, solution.maxDotProduct(intArrayOf(2, 1, -2, 5), intArrayOf(3, 0, -6)))
    }

    @Test
    fun computesSecondExample() {
        assertEquals(21, solution.maxDotProduct(intArrayOf(3, -2), intArrayOf(2, -6, 7)))
    }

    @Test
    fun computesAllNegativeExample() {
        assertEquals(-1, solution.maxDotProduct(intArrayOf(-1, -1), intArrayOf(1, 1)))
    }

    @Test
    fun swapsInputsToUseSmallerSecondDimension() {
        assertEquals(21, solution.maxDotProduct(intArrayOf(2, -6, 7), intArrayOf(3, -2)))
    }

    @Test
    fun handlesSingleElements() {
        assertEquals(-12, solution.maxDotProduct(intArrayOf(-3), intArrayOf(4)))
    }

    @Test
    fun skipsNegativeProductsWhenPositivePairExists() {
        assertEquals(35, solution.maxDotProduct(intArrayOf(-5, 3, 5), intArrayOf(1, -4, 3)))
    }
}
