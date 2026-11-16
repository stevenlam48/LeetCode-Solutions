package longesthappyprefix

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestHappyPrefixTest {
    private val solution = Solution()

    @Test
    fun standardExample() {
        assertEquals("l", solution.longestPrefix("level"))
    }

    @Test
    fun repeatingPattern() {
        assertEquals("abab", solution.longestPrefix("ababab"))
    }

    @Test
    fun repeatedCharacter() {
        assertEquals("aaa", solution.longestPrefix("aaaa"))
    }

    @Test
    fun noHappyPrefix() {
        assertEquals("", solution.longestPrefix("abc"))
    }

    @Test
    fun singleCharacter() {
        assertEquals("", solution.longestPrefix("a"))
    }
}
