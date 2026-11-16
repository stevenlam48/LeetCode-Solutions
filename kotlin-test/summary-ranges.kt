package summaryranges

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SummaryRangesTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(listOf("0->2", "4->5", "7"), solution.summaryRanges(intArrayOf(0, 1, 2, 4, 5, 7)))
    }

    @Test
    fun testExample2() {
        assertEquals(listOf("0", "2->4", "6", "8->9"), solution.summaryRanges(intArrayOf(0, 2, 3, 4, 6, 8, 9)))
    }

    @Test
    fun testEmpty() {
        assertEquals(emptyList<String>(), solution.summaryRanges(intArrayOf()))
    }

    @Test
    fun testSingleElement() {
        assertEquals(listOf("5"), solution.summaryRanges(intArrayOf(5)))
    }

    @Test
    fun testNegatives() {
        assertEquals(listOf("-3->-1", "1"), solution.summaryRanges(intArrayOf(-3, -2, -1, 1)))
    }
}
