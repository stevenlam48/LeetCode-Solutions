package countmagicalsubstringpairsii

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CountMagicalSubstringPairsIITest {
    private val solution = Solution()

    @Test
    fun testSingleCharacter() {
        assertEquals(0L, solution.countMagicalPairs("a"))
    }

    @Test
    fun testTwoCharacters() {
        assertEquals(1L, solution.countMagicalPairs("ab"))
        assertEquals(1L, solution.countMagicalPairs("aa"))
    }

    @Test
    fun testThreeCharacters() {
        assertEquals(2L, solution.countMagicalPairs("aba"))
        assertEquals(2L, solution.countMagicalPairs("abc"))
        assertEquals(3L, solution.countMagicalPairs("aab"))
    }

    @Test
    fun testLongerStrings() {
        assertEquals(4L, solution.countMagicalPairs("abab"))
        assertEquals(9L, solution.countMagicalPairs("abcabc"))
        assertEquals(6L, solution.countMagicalPairs("aabb"))
    }
}
