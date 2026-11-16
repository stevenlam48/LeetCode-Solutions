package replacequestionmarksinstringtominimizeitsvalue

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ReplaceQuestionMarksInStringToMinimizeItsValueTest {
    @Test
    fun example1() {
        assertEquals("abc", Solution().minimizeStringValue("???"))
    }

    @Test
    fun example2() {
        assertEquals("abac", Solution().minimizeStringValue("a?a?"))
    }

    @Test
    fun singleQuestionMark() {
        assertEquals("a", Solution().minimizeStringValue("?"))
    }

    @Test
    fun addsLeastFrequentLetter() {
        assertEquals("abcd", Solution().minimizeStringValue("abc?"))
    }

    @Test
    fun allLettersPresent() {
        assertEquals("abcdefghijklmnopqrstuvwxyza", Solution().minimizeStringValue("abcdefghijklmnopqrstuvwxyz?"))
    }

    @Test
    fun manyQuestionMarks() {
        assertEquals("acdeb", Solution().minimizeStringValue("a???b"))
    }
}
