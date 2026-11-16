package smallestsubsequenceofdistinctcharacters

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SmallestSubsequenceOfDistinctCharactersTest {
    private val solution = Solution()

    @Test
    fun examples() {
        assertEquals("abc", solution.smallestSubsequence("bcabc"))
        assertEquals("acdb", solution.smallestSubsequence("cbacdcbc"))
    }

    @Test
    fun repeatedSingleCharacter() {
        assertEquals("a", solution.smallestSubsequence("aaaa"))
    }

    @Test
    fun descendingDistinctCharacters() {
        assertEquals("zyx", solution.smallestSubsequence("zyx"))
    }

    @Test
    fun singleCharacter() {
        assertEquals("b", solution.smallestSubsequence("b"))
    }
}
