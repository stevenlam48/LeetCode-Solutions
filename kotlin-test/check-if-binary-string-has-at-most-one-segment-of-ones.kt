package checkifbinarystringhasatmostonesegmentofones

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CheckIfBinaryStringHasAtMostOneSegmentOfOnesTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertFalse(solution.checkOnesSegment("1001"))
    }

    @Test
    fun testExample2() {
        assertTrue(solution.checkOnesSegment("110"))
    }

    @Test
    fun testSingleOne() {
        assertTrue(solution.checkOnesSegment("1"))
    }

    @Test
    fun testTrailingZeros() {
        assertTrue(solution.checkOnesSegment("10"))
    }

    @Test
    fun testLeadingOnes() {
        assertTrue(solution.checkOnesSegment("111000"))
        assertFalse(solution.checkOnesSegment("110011"))
    }

    @Test
    fun testAllZeros() {
        assertTrue(solution.checkOnesSegment("0"))
    }
}
