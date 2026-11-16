package countofrangesum

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CountOfRangeSumTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(3, solution.countRangeSum(intArrayOf(-2, 5, -1), -2, 2))
    }

    @Test
    fun testExample2() {
        assertEquals(1, solution.countRangeSum(intArrayOf(0), 0, 0))
    }

    @Test
    fun testEmpty() {
        assertEquals(0, solution.countRangeSum(intArrayOf(), -1, 1))
    }

    @Test
    fun testAllZeros() {
        assertEquals(3, solution.countRangeSum(intArrayOf(0, 0), 0, 0))
    }

    @Test
    fun testNegatives() {
        assertEquals(3, solution.countRangeSum(intArrayOf(-1, -1), -2, 0))
    }
}
