package stringcompressionii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class StringCompressionIiTest {
    @Test
    fun `delete outliers and trailing character`() {
        assertEquals(4, Solution().getLengthOfOptimalCompression("aaabcccd", 2))
    }

    @Test
    fun `merge groups after deletion`() {
        assertEquals(2, Solution().getLengthOfOptimalCompression("aabbaa", 2))
    }

    @Test
    fun `eleven characters need a two digit count`() {
        assertEquals(3, Solution().getLengthOfOptimalCompression("aaaaaaaaaaa", 0))
    }

    @Test
    fun `delete the only character`() {
        assertEquals(0, Solution().getLengthOfOptimalCompression("a", 1))
    }
}
