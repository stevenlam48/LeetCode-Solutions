package minimumdeletionstomakecharacterfrequenciesunique
// Time:  O(n)
// Space: O(1)

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumDeletionsToMakeCharacterFrequenciesUniqueTest {
    private val solution = Solution()

    @Test
    fun leetCodeExamples() {
        assertEquals(0, solution.minDeletions("aab"))
        assertEquals(2, solution.minDeletions("aaabbbcc"))
        assertEquals(2, solution.minDeletions("ceabaacb"))
    }

    @Test
    fun allCharactersShareOneFrequency() {
        assertEquals(5, solution.minDeletions("aabbccdd"))
    }

    @Test
    fun emptyAndSingleCharacterStrings() {
        assertEquals(0, solution.minDeletions(""))
        assertEquals(0, solution.minDeletions("z"))
    }
}
