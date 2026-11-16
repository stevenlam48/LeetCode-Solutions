package decodeways

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DecodeWaysTest {
    @Test
    fun example1() {
        assertEquals(2, Solution().numDecodings("12"))
    }

    @Test
    fun example2() {
        assertEquals(3, Solution().numDecodings("226"))
    }

    @Test
    fun illegalZero() {
        assertEquals(0, Solution().numDecodings("06"))
        assertEquals(0, Solution().numDecodings("0"))
    }

    @Test
    fun tens() {
        assertEquals(1, Solution().numDecodings("10"))
        assertEquals(1, Solution().numDecodings("27"))
    }

    @Test
    fun withZeros() {
        assertEquals(1, Solution().numDecodings("2101"))
        assertEquals(2, Solution().numDecodings("11106"))
    }

    @Test
    fun empty() {
        assertEquals(0, Solution().numDecodings(""))
    }
}
