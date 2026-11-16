package countdistinctwaystoformtargetfromtwostrings

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountDistinctWaysToFormTargetFromTwoStringsTest {
    @Test
    fun bothCharactersNeeded() {
        assertEquals(2, Solution().interleaveCharacters("a", "a", "aa"))
    }

    @Test
    fun simpleInterleaving() {
        assertEquals(1, Solution().interleaveCharacters("a", "b", "ab"))
    }

    @Test
    fun cannotUseOnlyOneString() {
        assertEquals(0, Solution().interleaveCharacters("a", "a", "a"))
    }

    @Test
    fun sequentialSplit() {
        assertEquals(1, Solution().interleaveCharacters("ab", "cd", "abcd"))
    }

    @Test
    fun impossibleTarget() {
        assertEquals(0, Solution().interleaveCharacters("a", "b", "ac"))
    }

    @Test
    fun multipleInterleavings() {
        assertEquals(2, Solution().interleaveCharacters("ab", "ab", "abab"))
    }
}
