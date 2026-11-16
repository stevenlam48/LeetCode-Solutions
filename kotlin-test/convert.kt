package convert

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ConvertTest {
    @Test
    fun zigzagWithThreeRows() {
        assertEquals("PAHNAPLSIIGYIR", Solution().convert("PAYPALISHIRING", 3))
    }

    @Test
    fun zigzagWithFourRows() {
        assertEquals("PINALSIGYAHRPI", Solution().convert("PAYPALISHIRING", 4))
    }

    @Test
    fun oneRowReturnsOriginalString() {
        assertEquals("A", Solution().convert("A", 1))
    }

    @Test
    fun emptyString() {
        assertEquals("", Solution().convert("", 3))
    }
}
