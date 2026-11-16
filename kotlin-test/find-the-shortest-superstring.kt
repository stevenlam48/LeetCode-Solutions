package findtheshortestsuperstring

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FindTheShortestSuperstringTest {

    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(
            "alexlovesleetcode",
            solution.shortestSuperstring(listOf("alex", "loves", "leetcode"))
        )
    }

    @Test
    fun testExample2() {
        assertEquals(
            "gctaagttcatgcatc",
            solution.shortestSuperstring(listOf("catg", "ctaagt", "gcta", "ttca", "atgcatc"))
        )
    }

    @Test
    fun testSingleWord() {
        assertEquals("abc", solution.shortestSuperstring(listOf("abc")))
    }

    @Test
    fun testDuplicates() {
        assertEquals("abc", solution.shortestSuperstring(listOf("abc", "abc")))
    }

    @Test
    fun testDisjointWords() {
        assertEquals("abcd", solution.shortestSuperstring(listOf("ab", "cd")))
    }
}
