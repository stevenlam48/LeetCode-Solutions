package minimumlengthofstringafterdeletingsimilarends

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MinimumLengthOfStringAfterDeletingSimilarEndsTest {

    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(2, solution.minimumLength("ca"))
    }

    @Test
    fun testExample2() {
        assertEquals(0, solution.minimumLength("cabaabac"))
    }

    @Test
    fun testExample3() {
        assertEquals(3, solution.minimumLength("aabccabba"))
    }

    @Test
    fun testSingleCharacter() {
        assertEquals(1, solution.minimumLength("a"))
    }

    @Test
    fun testAllSameCharacters() {
        assertEquals(0, solution.minimumLength("aaaa"))
    }

    @Test
    fun testDistinctEnds() {
        assertEquals(4, solution.minimumLength("abcd"))
    }
}
