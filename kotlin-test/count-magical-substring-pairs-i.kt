package countmagicalsubstringpairsi

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CountMagicalSubstringPairsITest {
    private val solution = Solution()

    @Test
    fun testSingleCharacter() {
        assertEquals(0, solution.countMagicalPairs("a"))
    }

    @Test
    fun testTwoCharacters() {
        assertEquals(1, solution.countMagicalPairs("ab"))
        assertEquals(1, solution.countMagicalPairs("aa"))
    }

    @Test
    fun testThreeCharacters() {
        assertEquals(2, solution.countMagicalPairs("aba"))
        assertEquals(2, solution.countMagicalPairs("abc"))
        assertEquals(3, solution.countMagicalPairs("aab"))
    }

    @Test
    fun testLongerStrings() {
        assertEquals(4, solution.countMagicalPairs("abab"))
        assertEquals(9, solution.countMagicalPairs("abcabc"))
        assertEquals(6, solution.countMagicalPairs("aabb"))
    }
}
