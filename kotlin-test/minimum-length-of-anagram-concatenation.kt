package minimumlengthofanagramconcatenation

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MinimumLengthOfAnagramConcatenationTest {

    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(2, solution.minAnagramLength("abba"))
    }

    @Test
    fun testExample2() {
        assertEquals(4, solution.minAnagramLength("cdef"))
    }

    @Test
    fun testSingleCharacter() {
        assertEquals(1, solution.minAnagramLength("a"))
    }

    @Test
    fun testAllSameCharacters() {
        assertEquals(1, solution.minAnagramLength("aaaa"))
    }

    @Test
    fun testWholeStringNotDivisibleIntoEqualParts() {
        assertEquals(5, solution.minAnagramLength("abcde"))
    }

    @Test
    fun testEvenSplit() {
        assertEquals(3, solution.minAnagramLength("abcabc"))
    }
}
