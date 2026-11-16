package palindromicsubarraysum

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class PalindromicSubarraySumTest {
    @Test
    fun testExample() {
        assertEquals(5L, Solution().getSum(intArrayOf(1, 3, 1)))
    }

    @Test
    fun testAllDistinct() {
        assertEquals(3L, Solution().getSum(intArrayOf(1, 2, 3)))
    }

    @Test
    fun testTwoEqualElements() {
        assertEquals(4L, Solution().getSum(intArrayOf(2, 2)))
    }

    @Test
    fun testSingleElement() {
        assertEquals(7L, Solution().getSum(intArrayOf(7)))
    }

    @Test
    fun testMiddleElementLarger() {
        assertEquals(9L, Solution().getSum(intArrayOf(4, 1, 4)))
    }

    @Test
    fun testWholeArrayPalindrome() {
        assertEquals(10L, Solution().getSum(intArrayOf(1, 2, 4, 2, 1)))
    }
}
