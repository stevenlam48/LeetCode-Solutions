package thousandseparator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ThousandSeparatorTest {
    private val solution = Solution()

    @Test
    fun noSeparatorNeeded() {
        assertEquals("987", solution.thousandSeparator(987))
    }

    @Test
    fun oneSeparator() {
        assertEquals("1.234", solution.thousandSeparator(1234))
    }

    @Test
    fun multipleSeparators() {
        assertEquals("123.456.789", solution.thousandSeparator(123456789))
    }

    @Test
    fun zero() {
        assertEquals("0", solution.thousandSeparator(0))
    }
}
