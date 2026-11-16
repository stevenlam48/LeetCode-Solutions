package maximumsubarrayminproduct

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumSubarrayMinProductTest {
    @Test
    fun firstExample() {
        val solution = Solution()
        assertEquals(14, solution.maxSumMinProduct(intArrayOf(1, 2, 3, 2)))
    }

    @Test
    fun secondExample() {
        val solution = Solution()
        assertEquals(18, solution.maxSumMinProduct(intArrayOf(2, 3, 3, 1, 2)))
    }

    @Test
    fun thirdExample() {
        val solution = Solution()
        assertEquals(60, solution.maxSumMinProduct(intArrayOf(3, 1, 5, 6, 4, 2)))
    }

    @Test
    fun singleElement() {
        val solution = Solution()
        assertEquals(25, solution.maxSumMinProduct(intArrayOf(5)))
    }

    @Test
    fun equalElements() {
        val solution = Solution()
        assertEquals(36, solution.maxSumMinProduct(intArrayOf(3, 3, 3, 3)))
    }
}
