package findthestringwithlcp

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FindTheStringWithLcpTest {

    private val solution = Solution()

    @Test
    fun testExample1() {
        val lcp = arrayOf(
            intArrayOf(4, 0, 2, 0),
            intArrayOf(0, 3, 0, 1),
            intArrayOf(2, 0, 2, 0),
            intArrayOf(0, 1, 0, 1)
        )
        assertEquals("abab", solution.findTheString(lcp))
    }

    @Test
    fun testExample2() {
        val lcp = arrayOf(
            intArrayOf(4, 3, 2, 1),
            intArrayOf(3, 3, 2, 1),
            intArrayOf(2, 2, 2, 1),
            intArrayOf(1, 1, 1, 1)
        )
        assertEquals("aaaa", solution.findTheString(lcp))
    }

    @Test
    fun testExample3() {
        val lcp = arrayOf(
            intArrayOf(4, 3, 2, 1),
            intArrayOf(3, 3, 2, 1),
            intArrayOf(2, 2, 2, 1),
            intArrayOf(1, 1, 1, 3)
        )
        assertEquals("", solution.findTheString(lcp))
    }

    @Test
    fun testSingleCharacter() {
        assertEquals("a", solution.findTheString(arrayOf(intArrayOf(1))))
    }

    @Test
    fun testDistinctCharacters() {
        val lcp = arrayOf(
            intArrayOf(4, 0, 0, 0),
            intArrayOf(0, 3, 0, 0),
            intArrayOf(0, 0, 2, 0),
            intArrayOf(0, 0, 0, 1)
        )
        assertEquals("abcd", solution.findTheString(lcp))
    }
}
