package splitconcatenatedstrings

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SplitConcatenatedStringsTest {
    @Test
    fun `splits and reverses two strings for the standard result`() {
        assertEquals("zyxcba", Solution().splitLoopedString(listOf("abc", "xyz")))
    }

    @Test
    fun `uses the best rotation of a reversed single string`() {
        assertEquals("cba", Solution().splitLoopedString(listOf("abc")))
    }

    @Test
    fun `uses the middle string as the loop start`() {
        assertEquals("zyxfedcba", Solution().splitLoopedString(listOf("abc", "xyz", "def")))
    }

    @Test
    fun `handles equal forward and reversed strings`() {
        assertEquals("aaaaaa", Solution().splitLoopedString(listOf("aaa", "aaa")))
    }

    @Test
    fun `chooses a rotation spanning both string orientations`() {
        assertEquals("bbaa", Solution().splitLoopedString(listOf("ab", "ba")))
    }
}
