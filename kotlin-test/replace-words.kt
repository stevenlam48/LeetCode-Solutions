package replacewords

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ReplaceWordsTest {
    @Test
    fun example1() {
        assertEquals(
            "the cat was rat by the bat",
            Solution().replaceWords(
                listOf("cat", "bat", "rat"),
                "the cattle was rattled by the battery"
            )
        )
    }

    @Test
    fun example2() {
        assertEquals(
            "a a b c",
            Solution().replaceWords(
                listOf("a", "b", "c"),
                "aadsfasf absbs bbab cadsfafs"
            )
        )
    }

    @Test
    fun shortestRootWins() {
        assertEquals(
            "ab xyz",
            Solution().replaceWords(listOf("ab", "abc"), "abc xyz")
        )
    }

    @Test
    fun exactMatch() {
        assertEquals("abc", Solution().replaceWords(listOf("abc"), "abc"))
    }

    @Test
    fun noRoots() {
        assertEquals(
            "hello world",
            Solution().replaceWords(emptyList(), "hello world")
        )
    }
}
