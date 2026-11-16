package numberofperfectpairs

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class NumberOfPerfectPairsTest {
    @Test
    fun testExample1() {
        assertEquals(2L, Solution().perfectPairs(intArrayOf(0, 1, 2, 3)))
    }

    @Test
    fun testExample2() {
        assertEquals(3L, Solution().perfectPairs(intArrayOf(1, 1, 1)))
    }

    @Test
    fun testNegatives() {
        assertEquals(1L, Solution().perfectPairs(intArrayOf(-3, 3)))
    }

    @Test
    fun testSingleElement() {
        assertEquals(0L, Solution().perfectPairs(intArrayOf(5)))
    }

    @Test
    fun testAllZeros() {
        assertEquals(6L, Solution().perfectPairs(intArrayOf(0, 0, 0, 0)))
    }
}
