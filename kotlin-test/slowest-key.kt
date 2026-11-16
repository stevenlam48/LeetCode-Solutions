package slowestkey

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SlowestKeyTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals('c', solution.slowestKey(intArrayOf(9, 29, 49, 50), "cbcd"))
    }

    @Test
    fun testExample2() {
        assertEquals('a', solution.slowestKey(intArrayOf(12, 23, 36, 46, 62), "spuda"))
    }

    @Test
    fun testSingleKey() {
        assertEquals('a', solution.slowestKey(intArrayOf(1), "a"))
    }

    @Test
    fun testTieBreaksOnLargerChar() {
        assertEquals('b', solution.slowestKey(intArrayOf(1, 2), "ab"))
    }

    @Test
    fun testRepeatedKeyAccumulatesMax() {
        assertEquals('b', solution.slowestKey(intArrayOf(1, 2, 3), "aba"))
    }
}
