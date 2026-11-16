package longestduplicatesubstring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestDuplicateSubstringTest {
    private val solution = Solution()

    @Test
    fun standardExample() {
        assertEquals("ana", solution.longestDupSubstring("banana"))
    }

    @Test
    fun noDuplicateSubstring() {
        assertEquals("", solution.longestDupSubstring("abc"))
    }

    @Test
    fun singleRepeatedCharacter() {
        assertEquals("a", solution.longestDupSubstring("aa"))
    }

    @Test
    fun singleCharacterInput() {
        assertEquals("", solution.longestDupSubstring("a"))
    }
}
