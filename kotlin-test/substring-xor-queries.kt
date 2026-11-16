package substringxorqueries

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SubstringXorQueriesTest {
    @Test
    fun exampleOne() {
        val result = Solution().substringXorQueries(
            "101101",
            arrayOf(intArrayOf(0, 5), intArrayOf(1, 2))
        )
        assertArrayEquals(intArrayOf(0, 2), result[0])
        assertArrayEquals(intArrayOf(2, 3), result[1])
    }

    @Test
    fun missingSubstring() {
        val result = Solution().substringXorQueries("0101", arrayOf(intArrayOf(12, 8)))
        assertArrayEquals(intArrayOf(-1, -1), result[0])
    }

    @Test
    fun zeroUsesShortestLeftmostMatch() {
        val result = Solution().substringXorQueries(
            "01",
            arrayOf(intArrayOf(0, 0), intArrayOf(0, 1), intArrayOf(1, 1))
        )
        assertArrayEquals(intArrayOf(0, 0), result[0])
        assertArrayEquals(intArrayOf(1, 1), result[1])
        assertArrayEquals(intArrayOf(0, 0), result[2])
    }

    @Test
    fun repeatedQueriesAreIndependent() {
        val result = Solution().substringXorQueries(
            "111",
            arrayOf(intArrayOf(1, 6), intArrayOf(1, 6))
        )
        assertArrayEquals(intArrayOf(0, 2), result[0])
        assertArrayEquals(intArrayOf(0, 2), result[1])
        assertNotSame(result[0], result[1])
    }
}
