package minimumchangestomakeksemipalindromes

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumChangesToMakeKSemiPalindromesTest {
    @Test
    fun standardExamples() {
        assertEquals(1, Solution().minimumChanges("abcac", 2))
        assertEquals(2, Solution().minimumChanges("abcdef", 2))
        assertEquals(2, Solution().minimumChanges("aabbaa", 2))
    }

    @Test
    fun twoCharacterString() {
        assertEquals(1, Solution().minimumChanges("ab", 1))
        assertEquals(0, Solution().minimumChanges("aa", 1))
    }

    @Test
    fun singleGroup() {
        assertEquals(0, Solution().minimumChanges("abba", 1))
        assertEquals(2, Solution().minimumChanges("abcd", 1))
    }
}
