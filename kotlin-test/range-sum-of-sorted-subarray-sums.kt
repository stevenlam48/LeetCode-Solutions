package rangesumofsortedsubarraysums

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RangeSumOfSortedSubarraySumsTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(13, solution.rangeSum(intArrayOf(1, 2, 3, 4), 4, 1, 5))
    }

    @Test
    fun testExample2() {
        assertEquals(6, solution.rangeSum(intArrayOf(1, 2, 3, 4), 4, 3, 4))
    }

    @Test
    fun testExample3() {
        assertEquals(50, solution.rangeSum(intArrayOf(1, 2, 3, 4), 4, 1, 10))
    }

    @Test
    fun testSingleElement() {
        assertEquals(1, solution.rangeSum(intArrayOf(1), 1, 1, 1))
    }

    @Test
    fun testDuplicates() {
        assertEquals(3, solution.rangeSum(intArrayOf(1, 1, 1), 3, 1, 3))
    }
}
