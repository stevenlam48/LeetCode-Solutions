package sumofsubarrayranges

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SumOfSubarrayRangesTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(4L, solution.subArrayRanges(intArrayOf(1, 2, 3)))
    }

    @Test
    fun testExample2() {
        assertEquals(4L, solution.subArrayRanges(intArrayOf(1, 3, 3)))
    }

    @Test
    fun testExample3() {
        assertEquals(59L, solution.subArrayRanges(intArrayOf(4, -2, -3, 4, 1)))
    }

    @Test
    fun testSingleElement() {
        assertEquals(0L, solution.subArrayRanges(intArrayOf(7)))
    }

    @Test
    fun testAllEqual() {
        assertEquals(0L, solution.subArrayRanges(intArrayOf(5, 5, 5, 5)))
    }
}
