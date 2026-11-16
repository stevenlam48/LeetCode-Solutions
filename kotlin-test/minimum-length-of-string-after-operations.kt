package minimumlengthofstringafteroperations

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MinimumLengthOfStringAfterOperationsTest {

    private val solution = Solution()

    @Test
    fun testSingleCharacter() {
        assertEquals(1, solution.minimumLength("a"))
    }

    @Test
    fun testOddFrequency() {
        assertEquals(1, solution.minimumLength("aaaaa"))
    }

    @Test
    fun testEvenFrequency() {
        assertEquals(2, solution.minimumLength("aa"))
    }

    @Test
    fun testMixedFrequencies() {
        assertEquals(3, solution.minimumLength("aabbb"))
    }

    @Test
    fun testAllDistinct() {
        assertEquals(3, solution.minimumLength("abc"))
    }

    @Test
    fun testAdjacentPairs() {
        assertEquals(8, solution.minimumLength("aabbccdd"))
    }
}
