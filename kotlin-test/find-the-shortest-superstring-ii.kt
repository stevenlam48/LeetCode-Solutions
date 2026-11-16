package findtheshortestsuperstringii

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FindTheShortestSuperstringIiTest {

    private val solution = Solution()

    @Test
    fun testOverlapSuffixPrefix() {
        assertEquals("abcd", solution.shortestSuperstring("abc", "bcd"))
    }

    @Test
    fun testExampleFromProblem() {
        assertEquals("abcde", solution.shortestSuperstring("abc", "cde"))
    }

    @Test
    fun testEqualStrings() {
        assertEquals("ab", solution.shortestSuperstring("ab", "ab"))
    }

    @Test
    fun testContainedString() {
        assertEquals("abc", solution.shortestSuperstring("abc", "b"))
        assertEquals("abc", solution.shortestSuperstring("b", "abc"))
    }

    @Test
    fun testNoOverlap() {
        assertEquals("cdab", solution.shortestSuperstring("ab", "cd"))
    }
}
