package expressivewords

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ExpressiveWordsTest {
    private val solution = Solution()

    @Test
    fun `matches only stretchy words from standard example`() {
        assertEquals(1, solution.expressiveWords("heeellooo", listOf("hello", "hi", "helo")))
    }

    @Test
    fun `allows equal shorter and stretched groups`() {
        assertEquals(3, solution.expressiveWords("aaa", listOf("a", "aa", "aaa", "aaaa")))
    }

    @Test
    fun `cannot stretch a group shorter than three`() {
        assertEquals(1, solution.expressiveWords("abcd", listOf("abcd", "abbcd", "abbbcd")))
    }

    @Test
    fun `handles empty strings`() {
        assertEquals(1, solution.expressiveWords("", listOf("", "a")))
    }

    @Test
    fun `counts duplicate matching words independently`() {
        assertEquals(2, solution.expressiveWords("heeellooo", listOf("hello", "hello")))
    }
}
