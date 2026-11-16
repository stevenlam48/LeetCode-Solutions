package countpairsofsimilarstrings

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CountPairsOfSimilarStringsTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(2, solution.similarPairs(listOf("aba", "aabb", "abcd", "bac", "aabc")))
    }

    @Test
    fun testExample2() {
        assertEquals(3, solution.similarPairs(listOf("aabb", "ab", "ba")))
    }

    @Test
    fun testExample3() {
        assertEquals(0, solution.similarPairs(listOf("nba", "cba", "dba")))
    }

    @Test
    fun testSingleWord() {
        assertEquals(0, solution.similarPairs(listOf("abc")))
    }

    @Test
    fun testEmpty() {
        assertEquals(0, solution.similarPairs(listOf()))
    }
}
