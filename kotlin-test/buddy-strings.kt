package buddystrings

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class BuddyStringsTest {
    @Test
    fun example1() {
        assertTrue(Solution().buddyStrings("ab", "ba"))
    }

    @Test
    fun example2() {
        assertFalse(Solution().buddyStrings("ab", "ab"))
    }

    @Test
    fun example3() {
        assertTrue(Solution().buddyStrings("aa", "aa"))
    }

    @Test
    fun duplicateCharacters() {
        assertTrue(Solution().buddyStrings("abab", "abab"))
    }

    @Test
    fun differentLengths() {
        assertFalse(Solution().buddyStrings("abc", "acd"))
    }

    @Test
    fun repeatedCharacters() {
        assertTrue(Solution().buddyStrings("aab", "aab"))
    }
}
