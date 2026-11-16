package subsequenceofsizekwiththelargestevensum

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SubsequenceOfSizeKWithTheLargestEvenSumTest {
    @Test
    fun testExample1() {
        assertEquals(14L, Solution().largestEvenSum(intArrayOf(4, 1, 5, 3, 1, 6, 2), 3))
    }

    @Test
    fun testExample2() {
        assertEquals(18L, Solution().largestEvenSum(intArrayOf(4, 1, 5, 3, 1, 6, 2), 4))
    }

    @Test
    fun testNoEvenSum() {
        assertEquals(-1L, Solution().largestEvenSum(intArrayOf(1, 1, 1), 1))
        assertEquals(-1L, Solution().largestEvenSum(intArrayOf(3, 3, 3), 3))
    }

    @Test
    fun testAllEven() {
        assertEquals(4L, Solution().largestEvenSum(intArrayOf(2, 2, 2), 2))
    }

    @Test
    fun testSingleElement() {
        assertEquals(-1L, Solution().largestEvenSum(intArrayOf(5), 1))
        assertEquals(4L, Solution().largestEvenSum(intArrayOf(4), 1))
    }

    @Test
    fun testMixedParity() {
        assertEquals(4L, Solution().largestEvenSum(intArrayOf(1, 2, 3), 2))
    }
}
