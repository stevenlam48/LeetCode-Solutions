package strangeprinter

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class StrangePrinterTest {
    @Test
    fun `repeated characters share turns`() {
        assertEquals(2, Solution().strangePrinter("aaabbb"))
    }

    @Test
    fun `separated repeated characters share turns`() {
        assertEquals(2, Solution().strangePrinter("aba"))
    }

    @Test
    fun `empty string needs no turns`() {
        assertEquals(0, Solution().strangePrinter(""))
    }

    @Test
    fun `interleaved string needs five turns`() {
        assertEquals(5, Solution().strangePrinter("abcabc"))
    }
}
