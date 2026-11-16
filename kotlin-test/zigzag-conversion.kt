package zigzagconversion

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ZigzagConversionTest {
    @Test
    fun example1() {
        assertEquals("PAHNAPLSIIGYIR", Solution().convert("PAYPALISHIRING", 3))
    }

    @Test
    fun example2() {
        assertEquals("PINALSIGYAHRPI", Solution().convert("PAYPALISHIRING", 4))
    }

    @Test
    fun singleRow() {
        assertEquals("PAYPALISHIRING", Solution().convert("PAYPALISHIRING", 1))
    }

    @Test
    fun singleCharacter() {
        assertEquals("A", Solution().convert("A", 1))
        assertEquals("A", Solution().convert("A", 5))
    }

    @Test
    fun rowsExceedLength() {
        assertEquals("ABC", Solution().convert("ABC", 5))
    }

    @Test
    fun twoRows() {
        assertEquals("ACBD", Solution().convert("ABCD", 2))
    }
}
