package countwordsobtainedafteraddingaletter

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountWordsObtainedAfterAddingALetterTest {
    @Test
    fun example1() {
        assertEquals(
            2,
            Solution().wordCount(
                listOf("ant", "act", "tack"),
                listOf("tack", "act", "acti")
            )
        )
    }

    @Test
    fun example2() {
        assertEquals(
            1,
            Solution().wordCount(
                listOf("ab", "a"),
                listOf("abc", "abcd")
            )
        )
    }

    @Test
    fun noMatches() {
        assertEquals(
            0,
            Solution().wordCount(
                listOf("a", "b"),
                listOf("cd", "ef")
            )
        )
    }

    @Test
    fun addedLetterAlreadyPresent() {
        assertEquals(
            0,
            Solution().wordCount(listOf("aa"), listOf("aaa"))
        )
    }

    @Test
    fun singleCharacterTarget() {
        assertEquals(
            0,
            Solution().wordCount(listOf("abc"), listOf("a"))
        )
    }
}
