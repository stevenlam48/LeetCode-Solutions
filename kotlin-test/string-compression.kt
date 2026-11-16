package stringcompression

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class StringCompressionTest {
    @Test
    fun `standard repeated groups`() {
        val chars = charArrayOf('a', 'a', 'b', 'b', 'c', 'c', 'c')
        val length = Solution().compress(chars)
        assertEquals(6, length)
        assertEquals("a2b2c3", chars.concatToString(0, length))
    }

    @Test
    fun `single character is unchanged`() {
        val chars = charArrayOf('a')
        val length = Solution().compress(chars)
        assertEquals(1, length)
        assertEquals("a", chars.concatToString(0, length))
    }

    @Test
    fun `multi digit count`() {
        val chars = CharArray(12) { 'a' }
        val length = Solution().compress(chars)
        assertEquals(3, length)
        assertEquals("a12", chars.concatToString(0, length))
    }

    @Test
    fun `empty input`() {
        assertEquals(0, Solution().compress(CharArray(0)))
    }
}
