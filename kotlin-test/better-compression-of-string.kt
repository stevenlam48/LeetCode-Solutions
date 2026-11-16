package bettercompressionofstring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BetterCompressionOfStringTest {
    @Test
    fun example1() {
        assertEquals("a2b3c1", Solution().betterCompression("a2b3c1"))
    }

    @Test
    fun mergesDuplicateLetters() {
        assertEquals("a4b3c1", Solution().betterCompression("a2b3c1a2"))
    }

    @Test
    fun singlePair() {
        assertEquals("a1", Solution().betterCompression("a1"))
    }

    @Test
    fun multiDigitCounts() {
        assertEquals("a10", Solution().betterCompression("a10"))
    }

    @Test
    fun sumExceedsOneDigit() {
        assertEquals("z10", Solution().betterCompression("z9z1"))
    }

    @Test
    fun threeOccurrences() {
        assertEquals("a13b2c3", Solution().betterCompression("a12b2c3a1"))
    }
}
