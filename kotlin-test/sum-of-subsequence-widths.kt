package sumofsubsequencewidths

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SumOfSubsequenceWidthsTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(6, solution.sumSubseqWidths(intArrayOf(2, 1, 3)))
    }

    @Test
    fun testExample2() {
        assertEquals(159, solution.sumSubseqWidths(intArrayOf(2, 3, 5, 7, 11)))
    }

    @Test
    fun testSingleElement() {
        assertEquals(0, solution.sumSubseqWidths(intArrayOf(5)))
    }

    @Test
    fun testAllEqual() {
        assertEquals(0, solution.sumSubseqWidths(intArrayOf(1, 1, 1)))
    }

    @Test
    fun testTwoElements() {
        assertEquals(3, solution.sumSubseqWidths(intArrayOf(1, 4)))
    }
}
