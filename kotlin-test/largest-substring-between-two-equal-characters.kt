package largestsubstringbetweentwoequalcharacters

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LargestSubstringBetweenTwoEqualCharactersTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(0, solution.maxLengthBetweenEqualCharacters("aa"))
    }

    @Test
    fun testExample2() {
        assertEquals(2, solution.maxLengthBetweenEqualCharacters("abca"))
    }

    @Test
    fun testExample3() {
        assertEquals(-1, solution.maxLengthBetweenEqualCharacters("cbzxy"))
    }

    @Test
    fun testNestedPair() {
        assertEquals(2, solution.maxLengthBetweenEqualCharacters("abba"))
    }

    @Test
    fun testSingleCharacter() {
        assertEquals(-1, solution.maxLengthBetweenEqualCharacters("a"))
    }
}
