package stringcompressioniii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class StringCompressionIiiTest {
    @Test
    fun `single runs`() {
        assertEquals("1a1b1c1d1e", Solution().compressedString("abcde"))
    }

    @Test
    fun `runs are split at nine`() {
        assertEquals("9a4a", Solution().compressedString("aaaaaaaaaaaaa"))
    }

    @Test
    fun `exactly nine characters`() {
        assertEquals("9b", Solution().compressedString("bbbbbbbbb"))
    }

    @Test
    fun `empty word`() {
        assertEquals("", Solution().compressedString(""))
    }
}
