package ransomnote
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class RansomNoteTest {
    @Test
    fun leetCodeExamples() {
        assertFalse(Solution().canConstruct("a", "b"))
        assertFalse(Solution().canConstruct("aa", "ab"))
        assertTrue(Solution().canConstruct("aa", "aab"))
    }

    @Test
    fun repeatedLettersRequireEnoughCopies() {
        assertTrue(Solution().canConstruct("aab", "baa"))
        assertFalse(Solution().canConstruct("aaa", "aa"))
        assertTrue(Solution().canConstruct("abc", "xxczbaya"))
    }

    @Test
    fun emptyRansomNote() {
        assertTrue(Solution().canConstruct("", ""))
        assertTrue(Solution().canConstruct("", "magazine"))
        assertFalse(Solution().canConstruct("a", ""))
    }
}
