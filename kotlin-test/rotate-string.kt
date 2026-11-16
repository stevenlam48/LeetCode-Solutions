package rotatestring

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class RotateStringTest {
    @Test
    fun leetCodeExampleRotated() {
        assertTrue(Solution().rotateString("abcde", "cdeab"))
    }

    @Test
    fun leetCodeExampleNotRotated() {
        assertFalse(Solution().rotateString("abcde", "abced"))
    }

    @Test
    fun bothEmpty() {
        assertTrue(Solution().rotateString("", ""))
    }

    @Test
    fun differentLengths() {
        assertFalse(Solution().rotateString("abc", "abcd"))
    }

    @Test
    fun singleCharacter() {
        assertTrue(Solution().rotateString("a", "a"))
        assertFalse(Solution().rotateString("a", "b"))
    }

    @Test
    fun longerRotation() {
        assertTrue(Solution().rotateString("rotation", "tionrota"))
    }

    @Test
    fun repeatedCharactersNotRotated() {
        assertFalse(Solution().rotateString("aabb", "abab"))
        assertTrue(Solution().rotateString("aabb", "abba"))
    }
}
