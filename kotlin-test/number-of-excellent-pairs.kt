package numberofexcellentpairs

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfExcellentPairsTest {
    @Test
    fun testExample1() {
        assertEquals(5L, Solution().countExcellentPairs(intArrayOf(1, 2, 3, 1), 3))
    }

    @Test
    fun testExample2() {
        assertEquals(0L, Solution().countExcellentPairs(intArrayOf(5, 1, 1), 10))
    }

    @Test
    fun testDuplicatesCollapse() {
        assertEquals(1L, Solution().countExcellentPairs(intArrayOf(1, 1, 1), 2))
    }

    @Test
    fun testTwoDistinctValues() {
        assertEquals(4L, Solution().countExcellentPairs(intArrayOf(1, 2), 2))
    }
}
